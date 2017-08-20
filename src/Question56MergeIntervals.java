package medium;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

public class Question56MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0)
            return result;
        intervals.sort((Interval a, Interval b) -> (a.start - b.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i += 1) {
            if (end >= intervals.get(i).start) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        System.out.println(merge(list));
    }
}
