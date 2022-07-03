package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(path,candidates,target,0,0);
        return res;
    }

    private void backtrack(List<Integer> path,int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin;i < candidates.length;i++) {

            if(i > begin && candidates[i] == candidates[i-1]) continue;

            sum = (candidates[i] + sum);

            if(sum <= target) {
                path.add(candidates[i]);
                backtrack(path,candidates,target,sum,i+1);
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }
}
