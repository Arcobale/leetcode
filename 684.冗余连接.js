/*
 * @lc app=leetcode.cn id=684 lang=javascript
 *
 * [684] 冗余连接
 */

// @lc code=start
/**
 * @param {number[][]} edges
 * @return {number[]}
 */
const n = 1005;
const father = new Array(n);

//寻根
const find = (u) => {
    return u == father[u] ? u : father[u] = find(father[u]);
}

//将v->u加入并查集
const join = (u, v) => {
    u = find(u);
    v = find(v);
    if (u == v) return;
    father[v] = u;
}

//判断两个节点的根是否相同
const same = (u, v) => {
    u = find(u);
    v = find(v);
    return u == v;
}
var findRedundantConnection = function(edges) {
    //并查集初始化
    for (let i = 0; i < n; i++) {
        father[i] = i;
    }
    for (let edge of edges) {
        if (same(edge[0], edge[1])) return edge;
        else join(edge[0], edge[1]);
    }
};
// @lc code=end

