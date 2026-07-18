class Solution {

  public String encode(List<String> strs) {
        if (strs.isEmpty()){
            return null;
        }
        String encoded="";
        for (int i=0;i<strs.size();i++){
            encoded+=strs.get(i);
            if ("".equals(strs.get(i))){
                encoded+="ခ";
            }
            if (i!=strs.size()-1){
                encoded+='က';
            }
        }
        return encoded;
    }

    public List<String> decode(String str) {
        if (str==null)
            return new ArrayList<>();
        else 
            return Arrays.stream(str.split("က")).map(s -> s.equals("ခ")?"":s).toList();
    }
}
