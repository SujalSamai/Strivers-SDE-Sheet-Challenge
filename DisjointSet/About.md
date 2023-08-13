### What is a Disjoint Set Data Structure?
A data structure that stores non overlapping or disjoint subset of elements is called disjoint set data structure. The disjoint set data structure supports following operations:
- Adding new sets to the disjoint set.
- Merging disjoint sets to a single disjoint set using Union operation.
- Finding representative of a disjoint set using Find operation.
- Check if two sets are disjoint or not. 

### Example
- We are given 10 individuals say, a, b, c, d, e, f, g, h, i, j
- Following are relationships to be added:
  ```
  a <-> b  
  b <-> d
  c <-> f
  c <-> i
  j <-> e
  g <-> j
  ```
- Given queries like whether a is a friend of d or not. We basically need to create following 4 groups and maintain a quickly accessible connection among group items:
    ```
    G1 = {a, b, d}
    G2 = {c, f, i}
    G3 = {e, g, j}
    G4 = {h}
    ```

**Find whether x and y belong to the same group or not, i.e. to find if x and y are direct/indirect friends.**
- Partitioning the individuals into different sets according to the groups in which they fall. This method is known as a Disjoint set Union which maintains a collection of Disjoint sets and each set is represented by one of its members.

- To answer the above question two key points to be considered are:
  - **How to Resolve sets?** Initially, all elements belong to different sets. After working on the given relations, we select a member as a representative. There can be many ways to select a representative, a simple one is to select with the biggest index. 
  - **Check if 2 persons are in the same group?** If representatives of two individuals are the same, then they’ll become friends.

### Data Structures used are:
1. Array: An array of integers is called Parent[]. If we are dealing with N items, i’th element of the array represents the i’th item. More precisely, the i’th element of the Parent[] array is the parent of the i’th item. These relationships create one or more virtual trees.
2. Tree: It is a Disjoint set. If two elements are in the same tree, then they are in the same Disjoint set. The root node (or the topmost node) of each tree is called the representative of the set. There is always a single unique representative of each set. A simple rule to identify a representative is if ‘i’ is the representative of a set, then Parent[i] = i. If i is not the representative of his set, then it can be found by traveling up the tree until we find the representative.