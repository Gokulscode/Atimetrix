import zipfile, re, xml.etree.ElementTree as ET

xlsx = 'Jenkins KPIs 20260413.xlsx'

with zipfile.ZipFile(xlsx, 'r') as z:
    # 1. Get sheet list from workbook
    wb_xml = z.read('xl/workbook.xml').decode('utf-8')
    wb_rels = z.read('xl/_rels/workbook.xml.rels').decode('utf-8')

    # Parse sheet names and their rIds
    sheet_names = re.findall(r'<sheet\b[^>]*name="([^"]+)"[^>]*r:id="([^"]+)"', wb_xml)
    # Parse rels: rId -> target
    rels = dict(re.findall(r'Id="([^"]+)"[^>]*Target="([^"]+)"', wb_rels))

    print("=== Sheet list ===")
    sheet_map = {}  # target -> sheet name
    for name, rid in sheet_names:
        target = rels.get(rid, '?')
        print(f"  {name:30s} rId={rid}  target={target}")
        sheet_map[target] = name

    # 2. For each pivot table, find which sheet it belongs to
    print("\n=== Pivot tables on SONAR sheet ===")
    for i in range(1, 86):
        pt_path = f'xl/pivotTables/pivotTable{i}.xml'
        rels_path = f'xl/pivotTables/_rels/pivotTable{i}.xml.rels'
        try:
            pt_xml = z.read(pt_path).decode('utf-8')
            # Find which worksheet references this pivot table via worksheet rels
        except:
            continue

    # Better approach: check each worksheet's rels for pivot table references
    for i in range(1, 20):
        ws_rels_path = f'xl/worksheets/_rels/sheet{i}.xml.rels'
        ws_path = f'xl/worksheets/sheet{i}.xml'
        try:
            ws_rels = z.read(ws_rels_path).decode('utf-8')
            ws_xml  = z.read(ws_path).decode('utf-8')
        except:
            continue

        # Find sheet name
        sheet_target = f'worksheets/sheet{i}.xml'
        sname = sheet_map.get(sheet_target, f'sheet{i}')

        # Find pivot table refs in worksheet rels
        pivot_refs = re.findall(r'Target="\.\./pivotTables/(pivotTable[0-9]+\.xml)"', ws_rels)
        if pivot_refs:
            print(f"\n  Sheet: {sname} (sheet{i}.xml)")
            for pt_ref in pivot_refs:
                pt_num = re.search(r'[0-9]+', pt_ref).group()
                pt_xml = z.read(f'xl/pivotTables/{pt_ref}').decode('utf-8')
                # Get name, location, cacheId
                name_m    = re.search(r'name="([^"]+)"', pt_xml)
                loc_m     = re.search(r'<location ref="([^"]+)"', pt_xml)
                cache_m   = re.search(r'cacheId="([^"]+)"', pt_xml)
                pf_m      = re.search(r'<pageFields[^>]*>(.*?)</pageFields>', pt_xml, re.DOTALL)
                print(f"    pivotTable{pt_num}: name={name_m.group(1) if name_m else '?'} | location={loc_m.group(1) if loc_m else '?'} | cacheId={cache_m.group(1) if cache_m else '?'}")
                if pf_m:
                    print(f"      pageFields: {pf_m.group(1).strip()}")

