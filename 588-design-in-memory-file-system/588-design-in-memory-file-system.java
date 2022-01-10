class FileSystem {
    class File {
        boolean isDir;
        String content, name;
        Map<String, File> children;
        public File(boolean isDir, String name) {
            this.isDir = isDir;
            this.content = isDir ? null : "";
            this.name = name;
            this.children = isDir ? new HashMap<String, File>() : null;
        }
    }
    
    File root;

    public FileSystem() {
        root = new File(true, "/");
    }
    
    public List<String> ls(String path) {
        String[] p = path.split("/");
        File cur = root;
        for (String pname : p) {
            if (pname.equals("")) continue;
            cur = cur.children.get(pname);
        }
        if (cur.isDir) {
            List<String> files = new ArrayList<String>(cur.children.keySet());
            Collections.sort(files);
            return files;
        } 
        List<String> res = new ArrayList<String>();
        res.add(cur.name);
        return res;
    }
    
    public void mkdir(String path) {
        String[] p = path.split("/");
        File cur = root;
        for (String pname : p) {
            if (pname.equals("")) continue;
            if (!cur.children.containsKey(pname)) {
                cur.children.put(pname, new File(true, pname));
            }
            cur = cur.children.get(pname);
        }
    }
    
    public void addContentToFile(String path, String content) {
        String[] p = path.split("/");
        File cur = root;
        for (int i = 1; i < p.length - 1; i++) {
            if (!cur.children.containsKey(p[i])) {
                cur.children.put(p[i], new File(true, p[i]));
            }
            cur = cur.children.get(p[i]);
        }
        String name = p[p.length - 1];
        if (!cur.children.containsKey(name)) {
            cur.children.put(name, new File(false, name));
        }
        File file = cur.children.get(name);
        file.content = file.content + content;
    }
    
    public String readContentFromFile(String path) {
        String[] p = path.split("/");
        File cur = root;
        for (int i = 1; i < p.length; i++) {
            cur = cur.children.get(p[i]);
        }
        return cur.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */