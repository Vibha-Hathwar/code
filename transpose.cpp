/*The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.*/
 vector<vector<int>> transpose(vector<vector<int>>& mat) {
        // code here
        int rows = mat.size();
        int cols = mat[0].size();

        vector<vector<int>> result(cols, vector<int>(rows));

        for(int i = 0; i < rows; ++i)
            for(int j = 0; j < cols; ++j)
                result[j][i] = mat[i][j]; 
        return result;
    }
