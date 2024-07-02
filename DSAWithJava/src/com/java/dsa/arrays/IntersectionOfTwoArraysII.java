class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int n1: nums1) {
            occurrenceMap.put(n1, occurrenceMap.getOrDefault(n1, 0) + 1);
        }
        for (int n2: nums2) {
            if (occurrenceMap.containsKey(n2) && occurrenceMap.get(n2) >= 1) {
                result.add(n2);
                occurrenceMap.put(n2, occurrenceMap.get(n2) - 1);
            }
        }
        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        return resultArray;
    }
}
