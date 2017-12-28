import java.util.*;

public class Question355DesignTwitter {
    /*
    class Twitter {
        private List<int[]> tweets;
        private Map<Integer, Set<Integer>> users;

        public Twitter() {
            this.tweets = new ArrayList<>();
            this.users = new HashMap<>();
        }

        private void addUser(int userId) {
            if (!this.users.containsKey(userId)) {
                this.users.put(userId, new HashSet<>());
            }
        }

        public void postTweet(int userId, int tweetId) {
            this.addUser(userId);
            this.tweets.add(new int[]{userId, tweetId});
        }
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

        public void follow(int followerId, int followeeId) {
            this.addUser(followerId);
            this.addUser(followeeId);
            Set<Integer> tmp = this.users.get(followerId);
            tmp.add(followeeId);
            this.users.replace(followerId, tmp);
        }

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
    */

    // better solution
    public static class Twitter {
        private static int timeStamp=0;

        // easy to find if user exist
        private Map<Integer, User> userMap;

        // Tweet link to next Tweet so that we can save a lot of time
        // when we execute getNewsFeed(userId)
        private class Tweet{
            public int id;
            public int time;
            public Tweet next;

            public Tweet(int id){
                this.id = id;
                time = timeStamp++;
                next=null;
            }
        }


        // OO design so User can follow, unfollow and post itself
        public class User{
            public int id;
            public Set<Integer> followed;
            public Tweet tweet_head;

            public User(int id){
                this.id=id;
                followed = new HashSet<>();
                follow(id); // first follow itself
                tweet_head = null;
            }

            public void follow(int id){
                followed.add(id);
            }

            public void unfollow(int id){
                followed.remove(id);
            }


            // everytime user post a new tweet, add it to the head of tweet list.
            public void post(int id){
                Tweet t = new Tweet(id);
                t.next=tweet_head;
                tweet_head=t;
            }
        }




        /** Initialize your data structure here. */
        public Twitter() {
            userMap = new HashMap<Integer, User>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!userMap.containsKey(userId)){
                User u = new User(userId);
                userMap.put(userId, u);
            }
            userMap.get(userId).post(tweetId);

        }



        // Best part of this.
        // first get all tweets lists from one user including itself and all people it followed.
        // Second add all heads into a max heap. Every time we poll a tweet with
        // largest time stamp from the heap, then we add its next tweet into the heap.
        // So after adding all heads we only need to add 9 tweets at most into this
        // heap before we get the 10 most recent tweet.
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new LinkedList<>();

            if(!userMap.containsKey(userId))   return res;

            Set<Integer> users = userMap.get(userId).followed;
            PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
            for(int user: users){
                Tweet t = userMap.get(user).tweet_head;
                // very imporant! If we add null to the head we are screwed.
                if(t!=null){
                    q.add(t);
                }
            }
            int n=0;
            while(!q.isEmpty() && n<10){
                Tweet t = q.poll();
                res.add(t.id);
                n++;
                if(t.next!=null)
                    q.add(t.next);
            }

            return res;

        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!userMap.containsKey(followerId)){
                User u = new User(followerId);
                userMap.put(followerId, u);
            }
            if(!userMap.containsKey(followeeId)){
                User u = new User(followeeId);
                userMap.put(followeeId, u);
            }
            userMap.get(followerId).follow(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(!userMap.containsKey(followerId) || followerId==followeeId)
                return;
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

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
