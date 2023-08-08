package Recursion.FloodFillRecursion;

public class Code {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Avoid infinite loop if the new and old colors are the same...
        if(image[sr][sc] == color) return image;
        // Run the fill function starting at the position given...
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        // If sr is less than 0 or greater equals to the length of image...
        // Or, If sc is less than 0 or greater equals to the length of image[0]...
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // If image[sr][sc] is not equal to previous color...
        if(cur != image[sr][sc]) return;
        // Update the image[sr][sc] as a color...
        image[sr][sc] = color;
        // Make four recursive calls to the function with (sr-1, sc), (sr+1, sc), (sr, sc-1) and (sr, sc+1)...
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}
