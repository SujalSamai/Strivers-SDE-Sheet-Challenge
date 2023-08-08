### Question
- An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image. 
- You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc]. 
- To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color. 
- Return the modified image after performing the flood fill.

### Sample Input
    image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
    image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

### Sample Output
    [[2,2,2],[2,2,0],[2,0,1]]
    [[0,0,0],[0,0,0]]

### Solution
- if the current cell has same color as that of the given color then return the matrix as it is
- else call fill function, which passes all the parameters, along with the color of the given cell
- if we go out of bound, return. or if the color in the given cell is not same as that of our current cell return (for eg: we have to convert cells having 1s to 2s, but if the current cell is 0, then we can't convert it to 2)
- else color the cell
- recursively traverse to all four directions

### Code
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Avoid infinite loop if the new and old colors are the same...
        if(image[sr][sc] == color) return image;
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if(cur != image[sr][sc]) return;
        image[sr][sc] = color;

        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }

### Other Techniques
- Graph DFS or BFS

### Complexity
1. Time Complexity - O(N*M)
2. Space Complexity - O(N*M)