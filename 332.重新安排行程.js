/*
 * @lc app=leetcode.cn id=332 lang=javascript
 *
 * [332] 重新安排行程
 */

// @lc code=start
/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function(tickets) {
    let result = ['JFK'];
    let map = {};

    // 创建出发-到达关系映射
    for (let ticket of tickets) {
        let [from, to] = ticket;
        if (!map[from]) {
            map[from] = [];
        }
        map[from].push(to);
    }
    
    // 对到达城市排序
    for (let fromCity in map) {
        map[fromCity].sort();
    }

    function backtracking() {
        if (result.length == tickets.length + 1) {
            return true;
        }

        let lastCity = result[result.length - 1];
        if (!map[lastCity] || !map[lastCity].length) return false;

        for (let i = 0; i < map[lastCity].length; i++) {
            let toCity = map[lastCity][i];
            map[lastCity].splice(i, 1);  //删除元素
            result.push(toCity);
            if (backtracking()) return true;
            map[lastCity].splice(i, 0, toCity);
            result.pop();
        }
    }

    backtracking();
    return result;
};
// @lc code=end

