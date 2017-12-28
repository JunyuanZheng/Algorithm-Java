import java.util.*;

public class Question355DesignTwitter {
    static class Twitter {
        private List<int[]> tweets;
        private Map<Integer, Set<Integer>> users;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            this.tweets = new ArrayList<>();
            this.users = new HashMap<>();
        }

        private void addUser(int userId) {
            if (!this.users.containsKey(userId)) {
                this.users.put(userId, new HashSet<>());
            }
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            this.addUser(userId);
            this.tweets.add(new int[]{userId, tweetId});
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            this.addUser(userId);
            List<Integer> result = new ArrayList<>();
            Set<Integer> users = new HashSet<>();
            users.add(userId);
            users.addAll(this.users.get(userId));
            int i = tweets.size() - 1;
            while (result.size() < 10 && i >= 0) {
                int[] tweet = this.tweets.get(i);
                if (users.contains(tweet[0])) {
                    result.add(tweet[1]);
                }
                i -= 1;
            }
            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            this.addUser(followerId);
            this.addUser(followeeId);
            Set<Integer> tmp = this.users.get(followerId);
            tmp.add(followeeId);
            this.users.replace(followerId, tmp);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            this.addUser(followerId);
            this.addUser(followeeId);
            Set<Integer> tmp = this.users.get(followerId);
            if (tmp.contains(followeeId)) {
                tmp.remove(followeeId);
                this.users.replace(followerId, tmp);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }
}
