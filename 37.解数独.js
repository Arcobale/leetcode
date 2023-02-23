/*
 * @lc app=leetcode.cn id=37 lang=javascript
 *
 * [37] 解数独
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {
    // 检查数独是否合法
    function isValid(row, col, value) {
        let n = board.length;
        // 检查列
        for (let i = 0; i < n; i++) {
            if (board[i][col] == value) return false;
        }
        // 检查行
        for (let j = 0; j < n; j++) {
            if (board[row][j] == value) return false;
        }
        // 检查九宫格
        let startRow = Math.floor(row / 3) * 3;
        let startCol = Math.floor(col / 3) * 3;
        for (let i = startRow; i < startRow + 3; i++) {
            for (let j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    function backtracking() {
        for (let i = 0; i < board.length; i++) {
            for (let j = 0; j < board[0].length; j++) {
                if (board[i][j] != ".") continue;
                for (let k = 1; k <= 9; k++) {
                    if (isValid(i, j, k)) {
                        board[i][j] = String(k);
                        if (backtracking()) return true;
                        board[i][j] = ".";
                    }
                }
                return false; //无解
            }
        }
        return true;
    }
    backtracking();
    return board;
};
// @lc code=end

