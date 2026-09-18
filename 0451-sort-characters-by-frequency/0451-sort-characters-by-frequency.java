class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> {
            if(map.get(b) != map.get(a)) {
                return map.get(b) - map.get(a);
            }
            return a - b;
        });

        StringBuilder ans = new StringBuilder();

        for(char ch : list) {
            int freq = map.get(ch);

            while(freq-- > 0) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}