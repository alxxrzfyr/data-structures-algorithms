# Data Structures & Algorithm (Java)

A practical guide to data structures, algorithms, and problem solving in Java.

## Table of contents

- [I. PURPOSE AND SCOPE](#purpose)
  - [1. Learning objectives](#objectives)
  - [2. Topic categories](#categories)
- [II. REPOSITORY ORGANIZATION](#organization)
  - [1. Folder and file structure](#structure)
  - [2. Reading a topic file](#topic-format)
- [III. SETUP AND STUDY PROCEDURE](#procedure)
  - [1. Check the Java installation](#installation)
  - [2. Compile and run an example](#running)
  - [3. Complete a topic](#study)
  - [4. Read complexity notation](#complexity)
- [IV. CURRICULUM AND LESSON INDEX](#curriculum)
  - [1. Foundations](#lesson-00)
  - [2. Arrays](#lesson-01)
  - [3. Strings](#lesson-strings)
  - [4. ArrayList](#lesson-02)
  - [5. Linked Lists](#lesson-03)
  - [6. Stacks](#lesson-04)
  - [7. Queues](#lesson-05)
  - [8. Hash maps](#lesson-06)
  - [9. Hash sets](#lesson-07)
  - [10. Recursion](#lesson-08)
  - [11. Searching](#lesson-09)
  - [12. Sorting](#lesson-10)
  - [13. Trees](#lesson-11)
  - [14. Heaps](#lesson-12)
  - [15. Graphs](#lesson-13)
  - [16. Tries](#lesson-14)
  - [17. Algorithm patterns](#lesson-15)
  - [18. Graph algorithms](#lesson-16)
  - [19. Greedy algorithms](#lesson-17)
  - [20. Backtracking](#lesson-18)
  - [21. Dynamic programming](#lesson-19)
  - [22. Disjoint sets](#lesson-20)
  - [23. Bit manipulation](#lesson-21)
  - [24. Problem solving (optional only)](#lesson-22)
- [V. JAVA APIS AND IMPLEMENTATION NOTES](#java-notes)
  - [1. Using reference sources](#source-guide)
  - [2. Implementation notes](#implementation-notes)
- [VI. ASSUMPTIONS, LIMITS, AND PRACTICE](#limits)
  - [1. Input and implementation limits](#input-limits)
  - [2. Practice and completion criteria](#practice)
- [VII. REFERENCES](#references)

<a id="purpose"></a>
## I. PURPOSE AND SCOPE

<a id="objectives"></a>
### 1. Learning objectives

By completing the curriculum, you should be able to:

1. Explain how common data structures store and organize values.
2. Implement their essential operations before comparing Java's collections.
3. Estimate time and extra space as the input grows.
4. Choose an algorithm from the input constraints and explain why it works.
5. Compare a direct solution with an improved solution, including its tradeoffs.
6. Test ordinary inputs, boundary cases, and invalid inputs where the program defines their behavior.

The repository uses plain Java. Lessons require no framework, Maven, Gradle, or external library.

<a id="categories"></a>
### 2. Topic categories

| Category | Central question | Examples |
| --- | --- | --- |
| Foundations | What knowledge supports later topics? | Complexity, references, generics, ordering, recursion |
| Data structures | How should values be organized? | Arrays, linked lists, maps, trees, heaps, graphs, tries, disjoint sets |
| Algorithms | What steps solve the problem? | Searching, sorting, graph algorithms, greedy methods, backtracking, dynamic programming |
| Problem-solving patterns | What reusable approach fits this problem? | Two pointers, sliding windows, prefix sums, fast and slow pointers, divide and conquer, bit manipulation |

Folder numbers define the learning order. Categories describe each topic's role.

<a id="organization"></a>
## II. REPOSITORY ORGANIZATION

<a id="structure"></a>
### 1. Folder and file structure

Each numbered folder is a lesson area. Each Java file inside it is one runnable topic.

```text
java-dsa/
├── readme.md
├── 00-foundations/
│   ├── Complexity.java
│   ├── References.java
│   └── ...
├── 01-arrays/
│   ├── Basics.java
│   ├── Traversal.java
│   ├── MultidimensionalArrays.java
│   └── ...
├── ...
└── 22-problem-solving/
    ├── BeginnerTwoSum.java
    └── ...
```

Folder names use lowercase kebab-case. Java class names use PascalCase. Files with the same class name in different folders are independent programs. Compile each lesson separately to avoid duplicate-class errors.

<a id="topic-format"></a>
### 2. Reading a topic file

Each file begins with a block comment containing an uppercase topic title, a short explanation, complexity, and a `Try` task. Selected code lines have aligned `// <----` comments explaining the operation beside the code.

Read the explanation, then trace the program. Sketch changing references or indexes when needed.

Manual implementations explain storage and operations. Java collection examples show how to use the corresponding API.

<a id="procedure"></a>
## III. SETUP AND STUDY PROCEDURE

<a id="installation"></a>
### 1. Check the Java installation

Use JDK 17 or newer. It includes the compiler and runtime. Check both commands:

```bash
java -version
javac -version
```

The compiler converts `.java` source files into `.class` files. Use `--release 17` with a newer JDK to target Java 17. [9](#ref-9)

<a id="running"></a>
### 2. Compile and run an example

From the repository root:

```bash
cd 01-arrays
javac Traversal.java
java Traversal
```

Use the class name without `.java` or `.class` when running the compiled program.

To compile all topics within the current lesson folder:

```bash
javac *.java
java MultidimensionalArrays
```

To check the Java 17 baseline with a newer compiler:

```bash
javac --release 17 *.java
java Traversal
```

These commands work inside a lesson folder. Return to the repository root with `cd ..` before entering a different lesson.

<a id="study"></a>
### 3. Complete a topic

1. Read the explanation and state the problem in your own words.
2. Predict the output and trace one operation on paper.
3. Compile and run the file. Compare the result with your prediction.
4. Change the input, including a boundary case allowed by the implementation.
5. Complete the `Try` task without copying the solution.
6. Explain the time and extra space before moving on.

For a structure, study its manual implementation before its Java collection example. For a problem-solving pattern, write a direct solution first, identify repeated work, and explain what the improved solution avoids.

<a id="complexity"></a>
### 4. Read complexity notation

Big O describes how resource use grows with input size. It does not predict a fixed number of milliseconds.

| Notation | Example | Reason |
| --- | --- | --- |
| `O(1)` | Access an array element by index | The number of steps does not grow with the array length |
| `O(log n)` | Binary search | Each step removes about half the candidates |
| `O(n)` | Linear search | The search may inspect every element |
| `O(n log n)` | Merge sort | Each level processes the elements, across logarithmically many levels |
| `O(n²)` | Compare every pair | Each element can be paired with every other element |

Unless a topic says otherwise, `n` is the number of input elements and space means extra storage beyond the input. Recursive calls also consume space. Graph lessons use `V` for vertices and `E` for edges. Trie lessons may use word length instead of collection size.

Worst-case bounds describe the most expensive input; average-case bounds depend on an input model. Amortized analysis spreads costs across a sequence. ArrayList append is amortized `O(1)`, although resizing copies elements. [2](#ref-2)

<a id="curriculum"></a>
## IV. CURRICULUM AND LESSON INDEX

Follow the lessons and their topic bullets in the order listed.

Some lessons preview later material. Priority-queue usage appears before heap internals; heap sort introduces the heap property before the dedicated heap lesson. The graph-algorithm lesson introduces disjoint sets before Kruskal; the dedicated disjoint-set lesson develops compression and rank. Revisit these examples after studying their underlying structures.

<a id="lesson-00"></a>
### 1. Foundations

Compare growth rates, follow object references, use generics and ordering, and justify loop correctness and termination.

- [Abstract data types](00-foundations/AbstractDataType.java)
- [Complexity](00-foundations/Complexity.java)
- [Growth bounds](00-foundations/GrowthBounds.java)
- [References](00-foundations/References.java)
- [Equality and hashing](00-foundations/Equality.java)
- [Generics](00-foundations/Generics.java)
- [Natural ordering](00-foundations/NaturalOrdering.java)
- [Custom ordering](00-foundations/CustomOrdering.java)
- [Loop invariants](00-foundations/LoopInvariant.java)
- [Termination](00-foundations/Termination.java)

<a id="lesson-01"></a>
### 2. Arrays

Read and traverse indexed values, shift elements, work with rows and columns, and solve small array problems.

- [Basics](01-arrays/Basics.java)
- [Traversal](01-arrays/Traversal.java)
- [Insertion](01-arrays/Insertion.java)
- [Deletion](01-arrays/Deletion.java)
- [Multidimensional arrays](01-arrays/MultidimensionalArrays.java)
- [Prefix sum](01-arrays/PrefixSum.java)
- [Two pointers](01-arrays/TwoPointers.java)
- [Find largest](01-arrays/FindLargest.java)
- [Reverse array](01-arrays/ReverseArray.java)
- [Count occurrences](01-arrays/CountOccurrences.java)
- [Two sum](01-arrays/TwoSum.java)

<a id="lesson-strings"></a>
### 3. Strings

Traverse immutable text, count characters, solve small string problems, and distinguish UTF-16 code units from Unicode code points.

- [Traversal](01-strings/Traversal.java)
- [Character frequencies](01-strings/CharacterFrequency.java)
- [Palindrome](01-strings/Palindrome.java)
- [Anagram](01-strings/Anagram.java)
- [StringBuilder](01-strings/BuildingStrings.java)
- [Unicode code points](01-strings/Unicode.java)

<a id="lesson-02"></a>
### 4. ArrayList

Build a resizable array before using ArrayList. Compare logical size with backing-array capacity.

- [Custom array list](02-arraylist/CustomArrayList.java)
- [Amortized analysis](02-arraylist/AmortizedAnalysis.java)
- [Basics](02-arraylist/Basics.java)
- [Methods](02-arraylist/Methods.java)
- [Traversal](02-arraylist/Traversal.java)

<a id="lesson-03"></a>
### 5. Linked Lists

Connect nodes manually, change links, reverse a list, and detect a cycle with two moving references.

- [Singly linked list](03-linked-list/SinglyLinkedList.java)
- [Doubly linked list](03-linked-list/DoublyLinkedList.java)
- [Circular linked list](03-linked-list/CircularLinkedList.java)
- [Insertion](03-linked-list/Insertion.java)
- [Deletion](03-linked-list/Deletion.java)
- [Reversal](03-linked-list/Reversal.java)
- [Fast slow pointer](03-linked-list/FastSlowPointer.java)
- [Detect cycle](03-linked-list/DetectCycle.java)

<a id="lesson-04"></a>
### 6. Stacks

Implement last-in, first-out behavior, compare Stack with ArrayDeque, and apply stacks to brackets and expressions.

- [Array stack](04-stacks/ArrayStack.java)
- [Linked stack](04-stacks/LinkedStack.java)
- [Java stack](04-stacks/JavaStack.java)
- [Deque stack](04-stacks/DequeStack.java)
- [Balanced parentheses](04-stacks/BalancedParentheses.java)
- [Infix](04-stacks/Infix.java)
- [Postfix](04-stacks/Postfix.java)
- [Reverse string](04-stacks/ReverseString.java)

<a id="lesson-05"></a>
### 7. Queues

Implement first-in, first-out behavior, reuse slots in a circular queue, and compare deque and priority-based removal.

- [Array queue](05-queues/ArrayQueue.java)
- [Linked queue](05-queues/LinkedQueue.java)
- [Circular queue](05-queues/CircularQueue.java)
- [Deque example](05-queues/DequeExample.java)
- [Priority queue example](05-queues/PriorityQueueExample.java)
- [First in first out](05-queues/FirstInFirstOut.java)

<a id="lesson-06"></a>
### 8. Hash maps

Compute bucket indexes, resolve collisions, build a small map, and use HashMap for counting and lookup.

- [Hashing](06-hashmaps/Hashing.java)
- [Chaining](06-hashmaps/Chaining.java)
- [Map removal](06-hashmaps/MapRemoval.java)
- [Open addressing](06-hashmaps/OpenAddressing.java)
- [Probing tombstones](06-hashmaps/Tombstones.java)
- [Custom hash map](06-hashmaps/CustomHashMap.java)
- [Load factor and rehashing](06-hashmaps/Rehashing.java)
- [Key value pairs](06-hashmaps/KeyValuePairs.java)
- [Java hash map](06-hashmaps/JavaHashMap.java)
- [Mutable keys](06-hashmaps/MutableKeys.java)
- [Frequency counting](06-hashmaps/FrequencyCounting.java)
- [Two sum](06-hashmaps/TwoSum.java)

<a id="lesson-07"></a>
### 9. Hash sets

Represent uniqueness, reject duplicates, and calculate intersections. Read the hash-map lesson first.

- [Custom hash set](07-hashsets/CustomHashSet.java)
- [Basics](07-hashsets/Basics.java)
- [Java hash set](07-hashsets/JavaHashSet.java)
- [Duplicate detection](07-hashsets/DuplicateDetection.java)
- [Intersections](07-hashsets/Intersections.java)

<a id="lesson-08"></a>
### 10. Recursion

Trace calls and returns, identify the base case, and explain how each recursive call reduces the remaining work.

- [Base case](08-recursion/BaseCase.java)
- [Induction](08-recursion/Induction.java)
- [Call stack](08-recursion/CallStack.java)
- [Factorial](08-recursion/Factorial.java)
- [Recursive array sum](08-recursion/RecursiveArraySum.java)
- [Recursive string reversal](08-recursion/RecursiveStringReversal.java)
- [Fibonacci](08-recursion/Fibonacci.java)
- [Recursion trees](08-recursion/RecursionTree.java)

<a id="lesson-09"></a>
### 11. Searching

Compare scanning with repeated halving. Practice sorted-array search and the boundaries around duplicate values.

- [Linear search](09-searching/LinearSearch.java)
- [Binary search](09-searching/BinarySearch.java)
- [Lower bound](09-searching/LowerBound.java)
- [Upper bound](09-searching/UpperBound.java)
- [Naive substring search](09-searching/SubstringSearch.java)
- [KMP substring search](09-searching/KMP.java)

<a id="lesson-10"></a>
### 12. Sorting

Study simple comparison sorts before divide-and-conquer sorts, heap sort, counting sort, and radix sort.

- [Bubble sort](10-sorting/BubbleSort.java)
- [Selection sort](10-sorting/SelectionSort.java)
- [Insertion sort](10-sorting/InsertionSort.java)
- [Merge sort](10-sorting/MergeSort.java)
- [Quick sort](10-sorting/QuickSort.java)
- [Heap sort](10-sorting/HeapSort.java)
- [Counting sort](10-sorting/CountingSort.java)
- [Radix sort](10-sorting/RadixSort.java)
- [Comparison](10-sorting/Comparison.java)

<a id="lesson-11"></a>
### 13. Trees

Learn nodes and traversal before binary search trees, deletion, height, balance, and AVL rotations.

- [Binary tree](11-trees/BinaryTree.java)
- [Preorder](11-trees/Preorder.java)
- [Inorder](11-trees/Inorder.java)
- [Postorder](11-trees/Postorder.java)
- [Level order](11-trees/LevelOrder.java)
- [Iterative traversal](11-trees/IterativeTraversal.java)
- [Binary search tree](11-trees/BinarySearchTree.java)
- [Deletion](11-trees/Deletion.java)
- [Height](11-trees/Height.java)
- [Depth](11-trees/Depth.java)
- [Balanced trees](11-trees/BalancedTrees.java)
- [AVL tree](11-trees/AVLTree.java)
- [Java TreeMap](11-trees/TreeMapExample.java)
- [Java TreeSet](11-trees/TreeSetExample.java)

<a id="lesson-12"></a>
### 14. Heaps

Maintain parent-child priority, restore the heap property, and compare manual heaps with PriorityQueue.

- [Min heap example](12-heaps/MinHeapExample.java)
- [Heapify](12-heaps/Heapify.java)
- [Max heap](12-heaps/MaxHeap.java)
- [Priority queue example](12-heaps/PriorityQueueExample.java)
- [Top-k values](12-heaps/TopK.java)
- [Merge sorted sequences](12-heaps/MergeSorted.java)
- [Running median](12-heaps/RunningMedian.java)

<a id="lesson-13"></a>
### 15. Graphs

Model vertices and edges, choose a representation, then traverse graphs and identify components and cycles.

- [Directed vs undirected](13-graphs/DirectedVsUndirected.java)
- [Weighted vs unweighted](13-graphs/WeightedVsUnweighted.java)
- [Adjacency matrix](13-graphs/AdjacencyMatrix.java)
- [Adjacency list](13-graphs/AdjacencyList.java)
- [Breadth first search](13-graphs/BreadthFirstSearch.java)
- [Depth first search](13-graphs/DepthFirstSearch.java)
- [Connected components](13-graphs/ConnectedComponents.java)
- [Cycle detection](13-graphs/CycleDetection.java)

<a id="lesson-14"></a>
### 16. Tries

Store characters along paths and distinguish a complete word from a shared prefix.

- [Insertion](14-tries/Insertion.java)
- [Prefix search](14-tries/PrefixSearch.java)

<a id="lesson-15"></a>
### 17. Algorithm patterns

Recognize repeated work and replace it with two pointers, a window, prefix totals, or recursive splitting.

- [Brute force](15-algorithm-patterns/BruteForce.java)
- [Two pointers](15-algorithm-patterns/TwoPointers.java)
- [Sliding window](15-algorithm-patterns/SlidingWindow.java)
- [Fixed-size window](15-algorithm-patterns/FixedWindow.java)
- [Frequency window](15-algorithm-patterns/FrequencyWindow.java)
- [Kadane maximum subarray](15-algorithm-patterns/Kadane.java)
- [Monotonic stack](15-algorithm-patterns/MonotonicStack.java)
- [Binary search on the answer](15-algorithm-patterns/BinarySearchAnswer.java)
- [Prefix sum](15-algorithm-patterns/PrefixSum.java)
- [Fast slow pointer](15-algorithm-patterns/FastSlowPointer.java)
- [Divide and conquer](15-algorithm-patterns/DivideAndConquer.java)

<a id="lesson-16"></a>
### 18. Graph algorithms

Reuse traversal skills for dependency order, shortest paths, and minimum spanning trees.

- [BFS](16-graph-algorithms/BFS.java)
- [Path reconstruction](16-graph-algorithms/PathReconstruction.java)
- [DFS](16-graph-algorithms/DFS.java)
- [Directed cycles](16-graph-algorithms/DirectedCycle.java)
- [Bipartite graphs](16-graph-algorithms/Bipartite.java)
- [Topological sort](16-graph-algorithms/TopologicalSort.java)
- [Dijkstra](16-graph-algorithms/Dijkstra.java)
- [Bellman ford](16-graph-algorithms/BellmanFord.java)
- [Negative-cycle detection](16-graph-algorithms/NegativeCycle.java)
- [Floyd warshall](16-graph-algorithms/FloydWarshall.java)
- [Disjoint-set prerequisite](16-graph-algorithms/DisjointSetBasics.java)
- [Prim](16-graph-algorithms/Prim.java)
- [Minimum spanning forest](16-graph-algorithms/SpanningForest.java)
- [Kruskal](16-graph-algorithms/Kruskal.java)

<a id="lesson-17"></a>
### 19. Greedy algorithms

Make a local choice, explain why it preserves a solution, and identify examples where that choice fails.

- [Activity selection](17-greedy/ActivitySelection.java)
- [Coin problems](17-greedy/CoinProblems.java)

<a id="lesson-18"></a>
### 20. Backtracking

Choose, explore, and undo. Move from subsets and permutations to constrained searches such as queens and Sudoku.

- [Subsets](18-backtracking/Subsets.java)
- [Combinations](18-backtracking/Combinations.java)
- [Permutations](18-backtracking/Permutations.java)
- [Maze](18-backtracking/Maze.java)
- [N-queens](18-backtracking/NQueens.java)
- [Sudoku](18-backtracking/Sudoku.java)

<a id="lesson-19"></a>
### 21. Dynamic programming

Start with repeated recursive work, then define a state, transition, and base case before memoization or tabulation.

- [Overlapping subproblems](19-dynamic-programming/OverlappingSubproblems.java)
- [Optimal substructure](19-dynamic-programming/OptimalSubstructure.java)
- [Memoization](19-dynamic-programming/Memoization.java)
- [Tabulation](19-dynamic-programming/Tabulation.java)
- [Fibonacci](19-dynamic-programming/Fibonacci.java)
- [Climbing stairs](19-dynamic-programming/ClimbingStairs.java)
- [Grid paths](19-dynamic-programming/GridPaths.java)
- [Knapsack](19-dynamic-programming/Knapsack.java)
- [Knapsack reconstruction](19-dynamic-programming/KnapsackReconstruction.java)
- [Coin change](19-dynamic-programming/CoinChange.java)
- [Pseudopolynomial analysis](19-dynamic-programming/Pseudopolynomial.java)
- [Longest common subsequence](19-dynamic-programming/LongestCommonSubsequence.java)
- [LCS reconstruction](19-dynamic-programming/LCSReconstruction.java)

<a id="lesson-20"></a>
### 22. Disjoint sets

Track connected groups using parent links, then improve find and union with compression and rank.

- [Find](20-disjoint-set/Find.java)
- [Union](20-disjoint-set/Union.java)
- [Path compression](20-disjoint-set/PathCompression.java)
- [Union by rank](20-disjoint-set/UnionByRank.java)

<a id="lesson-21"></a>
### 23. Bit manipulation

Read binary values, combine bits, shift values, and represent a small set using a bitmask.

- [Binary basics](21-bit-manipulation/BinaryBasics.java)
- [Bitwise and](21-bit-manipulation/BitwiseAnd.java)
- [Bitwise or](21-bit-manipulation/BitwiseOr.java)
- [Xor](21-bit-manipulation/Xor.java)
- [Shifting](21-bit-manipulation/Shifting.java)
- [Bitwise operations](21-bit-manipulation/BitwiseOperations.java)
- [Bitmasking](21-bit-manipulation/Bitmasking.java)

<a id="lesson-22"></a>
### 24. Problem solving (optional only)

Choose a structure and algorithm from the problem constraints, explain the choice, and test the result.

- [Beginner two sum](22-problem-solving/BeginnerTwoSum.java)
- [Beginner Second Largest](22-problem-solving/BeginnerSecondLargest.java)
- [Beginner Palindrome](22-problem-solving/BeginnerPalindrome.java)
- [Easy contains duplicate](22-problem-solving/EasyContainsDuplicate.java)
- [Easy First Unique](22-problem-solving/EasyFirstUnique.java)
- [Easy Intersection](22-problem-solving/EasyIntersection.java)
- [Medium merge intervals](22-problem-solving/MediumMergeIntervals.java)
- [Medium Distinct Window](22-problem-solving/MediumDistinctWindow.java)
- [Medium Grid Path](22-problem-solving/MediumGridPath.java)
- [Hard shortest path](22-problem-solving/HardShortestPath.java)
- [Hard Minimum Window](22-problem-solving/HardMinimumWindow.java)
- [Mixed choose a pattern](22-problem-solving/MixedChooseAPattern.java)
- [Mixed Course Schedule](22-problem-solving/MixedCourseSchedule.java)

<a id="java-notes"></a>
## V. JAVA APIS AND IMPLEMENTATION NOTES

<a id="source-guide"></a>
### 1. Using reference sources

- Java specifications and API documentation define language rules and library behavior.
- OpenJDK source shows implementation details for a specific release. These details can change without changing the API contract.
- University materials explain algorithm design, correctness, and complexity.
- Community discussions offer practical questions. Confirm technical claims against official documentation.

The archived Java Tutorials use JDK 8. Use the Java SE 17 references for this curriculum's language and API requirements. [14](#ref-14)

<a id="implementation-notes"></a>
### 2. Implementation notes

| Topic | Key distinction | References |
| --- | --- | --- |
| Arrays | Length is fixed. Multidimensional arrays contain references to other arrays, so rows may have different lengths. | [1](#ref-1) |
| ArrayList | Indexed access is `O(1)` and append is amortized `O(1)`. The custom example doubles capacity; Java's API does not guarantee that growth factor. | [2](#ref-2), [12](#ref-12) |
| HashMap and HashSet | Basic lookups are expected `O(1)` when hashes spread entries well. Iteration order is not guaranteed. | [3](#ref-3), [4](#ref-4), [13](#ref-13) |
| Stacks and deques | Stack is a legacy API. Its documentation recommends Deque implementations. Use the same end for stack insertion and removal. | [5](#ref-5), [6](#ref-6), [11](#ref-11) |
| Equality and ordering | Equal objects need equal hash codes. TreeMap and TreeSet use comparison results to identify equivalent keys. | [24](#ref-24), [27](#ref-27), [28](#ref-28) |
| Strings | String is immutable. char indexes address UTF-16 code units; some code points use two units. StringBuilder supports repeated appends. | [25](#ref-25), [26](#ref-26), [29](#ref-29) |
| Priority queues | Insertion and head removal are `O(log n)`; reading the head is `O(1)`. Iteration is not sorted. | [7](#ref-7) |
| Searching and sorting | Binary search requires sorted input. A simple quicksort can take `O(n²)` with poor partitions. | [8](#ref-8), [15](#ref-15), [16](#ref-16) |
| Graph algorithms | Dijkstra requires nonnegative weights. A minimum spanning tree connects a weighted, undirected graph. | [17](#ref-17), [18](#ref-18) |
| Tries and disjoint sets | Tries share character prefixes. Union-find follows parent links; compression and rank improve repeated operations. | [19](#ref-19), [20](#ref-20) |
| Recursion and dynamic programming | Recursion needs a stopping condition. Memoization reuses results for repeated states. Define the state, transition, and base cases before coding. | [21](#ref-21), [22](#ref-22) |
| Bit manipulation | Java distinguishes signed and unsigned right shifts. Use parentheses to clarify combined bitwise expressions. | [10](#ref-10) |

The external algorithm listings are reading material. No Princeton `algs4` library is required.

<a id="limits"></a>
## VI. ASSUMPTIONS, LIMITS, AND PRACTICE

<a id="input-limits"></a>
### 1. Input and implementation limits

Read each file's input assumptions before changing its data. Manual implementations focus on essential operations.

| Area | Assumption or limit |
| --- | --- |
| Manual collections | Several structures have fixed capacity or a small operation set. They do not reproduce all Java collection contracts. Check empty/full behavior and valid indexes in the actual implementation. |
| Hash tables | Separate examples teach bucket removal, rehashing, and probing tombstones. Fixed-capacity examples still have a full-table limit. |
| Binary search and bounds | Input must be sorted in the ordering used by the search. |
| Counting and radix sorts | Examples handle nonnegative integers. Counting sort needs storage based on the value range, which can be much larger than the input length. |
| Sliding window | The variable-sum example requires positive values and a nonnegative limit. Fixed-size windows support negative values; frequency windows use character counts. |
| Recursive and numeric examples | Large inputs can overflow int or long, or exhaust the call stack. Big O does not prevent those failures. |
| Dijkstra | Use nonnegative weights. The small examples do not validate every input or prevent all distance-sum overflows. |
| Bellman-Ford | The basic example shows relaxation; NegativeCycle.java adds the extra pass that detects a reachable negative cycle. |
| Floyd-Warshall | The example uses 999 as an unreachable-distance marker for its small input. It is not a general infinity value or a complete strategy for arbitrary weights. |
| Minimum spanning trees | A spanning tree requires a connected undirected graph. SpanningForest.java starts a separate tree for each component; the basic Prim example explores one starting component. |
| Backtracking | The search space can grow rapidly. Small demonstration inputs do not imply that large instances will finish quickly. |

<a id="practice"></a>
### 2. Practice and completion criteria

Before moving to the next topic:

1. **Explain.** Describe the structure or algorithm using its correct programming terms.
2. **Trace.** Show how the values, indexes, references, or recursive calls change.
3. **Implement.** Rebuild the central operation without looking at the solution.
4. **Compare.** Explain the relevant Java API or an alternative solution, where one exists.
5. **Test.** Choose ordinary and boundary inputs. State which inputs are outside the example's supported domain.
6. **Justify.** Explain why the method works and give its time and extra-space bounds.

For a problem-solving exercise, record the input constraints, direct approach, repeated work, improved approach, and complexity comparison. For example, comparing all pairs in two-sum takes quadratic time; a hash-map approach has expected linear time under suitable hashing and uses extra storage. The direct approach appears in the brute-force lesson; the hash-map lesson shows the expected linear-time approach. [3](#ref-3)

Use the final problem-solving lesson to practice choosing an approach without being told the pattern first.

<a id="references"></a>
## VII. REFERENCES

Java references target version 17. OpenJDK links identify a fixed release. University materials support algorithm study; community discussions provide supplementary reading.

- <a id="ref-1"></a>[1] Oracle. [Java Language Specification, Java SE 17, Chapter 10: Arrays](https://docs.oracle.com/javase/specs/jls/se17/html/jls-10.html).
- <a id="ref-2"></a>[2] Oracle. [Java SE 17 API: ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html).
- <a id="ref-3"></a>[3] Oracle. [Java SE 17 API: HashMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html).
- <a id="ref-4"></a>[4] Oracle. [Java SE 17 API: HashSet](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashSet.html).
- <a id="ref-5"></a>[5] Oracle. [Java SE 17 API: Stack](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html).
- <a id="ref-6"></a>[6] Oracle. [Java SE 17 API: ArrayDeque](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayDeque.html).
- <a id="ref-7"></a>[7] Oracle. [Java SE 17 API: PriorityQueue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html).
- <a id="ref-8"></a>[8] Oracle. [Java SE 17 API: Arrays](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html).
- <a id="ref-9"></a>[9] Oracle. [Java SE 17 tool specification: javac](https://docs.oracle.com/en/java/javase/17/docs/specs/man/javac.html).
- <a id="ref-10"></a>[10] Oracle. [Java Language Specification, Java SE 17, Chapter 15: Expressions; sections 15.19 and 15.22](https://docs.oracle.com/javase/specs/jls/se17/html/jls-15.html).
- <a id="ref-11"></a>[11] Dev.java contributors. [The Collections Framework](https://dev.java/learn/api/collections-and-streams/collections-framework/).
- <a id="ref-12"></a>[12] OpenJDK contributors. [ArrayList.java, release tag jdk-17+35](https://github.com/openjdk/jdk/blob/jdk-17%2B35/src/java.base/share/classes/java/util/ArrayList.java).
- <a id="ref-13"></a>[13] OpenJDK contributors. [HashMap.java, release tag jdk-17+35](https://github.com/openjdk/jdk/blob/jdk-17%2B35/src/java.base/share/classes/java/util/HashMap.java).
- <a id="ref-14"></a>[14] Oracle. [The Java Tutorials: Generics, JDK 8-era tutorial](https://docs.oracle.com/javase/tutorial/java/generics/index.html).
- <a id="ref-15"></a>[15] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition: Java code index](https://algs4.cs.princeton.edu/code/index.php).
- <a id="ref-16"></a>[16] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition, section 2.3: Quicksort](https://algs4.cs.princeton.edu/23quicksort/).
- <a id="ref-17"></a>[17] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition, section 4.4: Shortest Paths](https://algs4.cs.princeton.edu/44sp/).
- <a id="ref-18"></a>[18] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition, section 4.3: Minimum Spanning Trees](https://algs4.cs.princeton.edu/43mst/).
- <a id="ref-19"></a>[19] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition, section 5.2: Tries](https://algs4.cs.princeton.edu/52trie/).
- <a id="ref-20"></a>[20] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition: UF.java source listing](https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/UF.java.html).
- <a id="ref-21"></a>[21] Robert Sedgewick and Kevin Wayne. [Introduction to Programming in Java, section 2.3: Recursion](https://introcs.cs.princeton.edu/java/23recursion/).
- <a id="ref-22"></a>[22] MIT OpenCourseWare. [6.006 Introduction to Algorithms, Fall 2011: Lecture 19, Dynamic Programming I](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-fall-2011/b6d4083131dd16e7d97f56d04b6e858f_MIT6_006F11_lec19.pdf).
- <a id="ref-23"></a>[23] Coderanch contributors. [If Stack is a LIFO then why do push() and pop() work at the front of the queue, and not at the end? Forum discussion](https://coderanch.com/t/778417/java/Stack-LIFO-push-pop-work).
- <a id="ref-24"></a>[24] Oracle. [Java SE 17 API: Object equality and hashing](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html).
- <a id="ref-25"></a>[25] Oracle. [Java SE 17 API: String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html).
- <a id="ref-26"></a>[26] Oracle. [Java SE 17 API: StringBuilder](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html).
- <a id="ref-27"></a>[27] Oracle. [Java SE 17 API: TreeMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeMap.html).
- <a id="ref-28"></a>[28] Oracle. [Java SE 17 API: TreeSet](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeSet.html).
- <a id="ref-29"></a>[29] Robert Sedgewick and Kevin Wayne. [Algorithms, 4th Edition, section 5.3: Substring Search](https://algs4.cs.princeton.edu/53substring/).
