
class Twitter {
    private Set<Integer>[] user;
    private List<int[]> tweets;

    @SuppressWarnings("unchecked")
    public Twitter() {
        user = new HashSet[501];
        for (int i = 0; i < 501; i++) user[i] = new HashSet<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{tweetId, userId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 && ans.size() < 10; i--) {
            int[] t = tweets.get(i);
            if (t[1] == userId || user[userId].contains(t[1])) {
                ans.add(t[0]);
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        user[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        user[followerId].remove(followeeId);
    }
}