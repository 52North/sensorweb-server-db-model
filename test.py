import glob, xml.etree.ElementTree as ET
from collections import Counter

ATTR = {'property','many-to-one','one-to-one','set','bag','list','map',
        'component','dynamic-component','any','array','idbag'}
SUB  = {'subclass','joined-subclass','union-subclass'}
local = lambda t: t.rsplit('}', 1)[-1]

def walk(el, inherited, path, f):
    names = [c.get('name') for c in el if local(c.tag) in ATTR and c.get('name')]
    for n, k in Counter(names).items():
        if k > 1:
            print(f"{f}: {path} declares '{n}' {k}x")
    for n in sorted(set(names) & inherited):
        print(f"{f}: {path} redeclares inherited '{n}'")
    combined = inherited | set(names)
    for c in el:
        if local(c.tag) in SUB:
            walk(c, combined, f"{path} > {c.get('name')}", f)

for f in glob.glob('./mappings/src/main/hbm/**/*.hbm.xml', recursive=True):
    for cls in ET.parse(f).getroot():
        if local(cls.tag) == 'class':
            walk(cls, set(), cls.get('name'), f)