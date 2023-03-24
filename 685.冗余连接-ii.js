/*
 * @lc app=leetcode.cn id=685 lang=javascript
 *
 * [685] 冗余连接 II
 */

// @lc code=start
/**
 * @param {number[][]} edges
 * @return {number[]}
 */
const n = 1005;
const father = new Array(n);

const find = (u) => {
    return u == father[u] ? u : father[u] = find(father[u]);
}
const join = (u, v) => {
    u = find(u);
    v = find(v);
    if (u == v) return;
    father[v] = u;
}
const same = (u, v) => {
    u = find(u);
    v = find(v);
    return u == v;
}
//当有环出现，删除其中一条边
const getRemoveEdge = edges => {
    for (let i = 0; i < n; i++) {
        father[i] = i;
    }
    for (let edge of edges) {
        if (same(edge[0], edge[1])) return edge;
        else join(edge[0] ,edge[1]);
    }
}
//判断删除入度为2的一条边后是否形成树
const isTreeAfterRemoveEdge = (edges, deleteEdge) => {
    for (let i = 0; i < n; i++) {
        father[i] = i;
    }
    for (let i = 0; i < edges.length; i++) {
        if (i == deleteEdge) continue;
        if (same(edges[i][0], edges[i][1])) return false;
        else join (edges[i][0], edges[i][1]);
    }
    return true;
}
var findRedundantDirectedConnection = function(edges) {
    let inDegree = new Array(edges.length + 1).fill(0);
    let deleteNode = [];
    for (let i = 0; i < edges.length; i++) {
        inDegree[edges[i][1]]++;
    }
    //从后向前查
    for (let i = edges.length - 1; i >= 0; i--) {
        if (inDegree[edges[i][1]] == 2) {
            deleteNode.push(i);
        }
    }
    if (deleteNode.length > 0) {
        if (isTreeAfterRemoveEdge(edges, deleteNode[0])) return edges[deleteNode[0]];
        else return edges[deleteNode[1]];
    }
    return getRemoveEdge(edges);
};
// @lc code=end

