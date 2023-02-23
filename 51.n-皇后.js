/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N 皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let result = [];
    let chessbord = new Array(n).fill([]).map(() => new Array(n).fill("."));

    // 将棋盘转换输出格式
    function transfromChessbord(chessbord) {
        let path = [];
        for (let i = 0; i < n; i++) {
            let rowStr = '';
            for (let j = 0; j < n; j++) {
                rowStr += chessbord[i][j];
            }
            path.push(rowStr);
        }
        return path;
    }

    // N皇后合法规则
    function isValid(row, col) {
        // 检查列
        for (let i = 0; i < row; i++) {
            if (chessbord[i][col] == "Q") return false;
        }
        // 检查45度角
        for (let i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessbord[i][j] == "Q") return false;
        }
        // 检查135度角
        for (let i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessbord[i][j] == "Q") return false;
        }
        return true;
    }

    function backtracking(row) {
        if (row == n) {
            result.push(transfromChessbord(chessbord));
            return;
        }
        for (let col = 0; col < n; col++) {
            if (isValid(row, col)) {
                chessbord[row][col] = "Q";
                backtracking(row + 1);
                chessbord[row][col] = ".";
            }
        }
    }

    backtracking(0);
    return result;
};
// @lc code=end

