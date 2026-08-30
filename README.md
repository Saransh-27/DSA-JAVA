# 🚀 Data Structures & Algorithms in Java

A structured collection of Data Structures and Algorithms solutions, concept procedures, and visual ASCII diagrams.

---

## 📂 Repository Layout

```text
Exersise/
│
├── 📁 01-Arrays/
│   ├── 📁 01-Basics-And-Math/
│   │   ├── EvenOrNot.java           # Count elements with even digit lengths
│   │   ├── arm.java                 # Armstrong number check
│   │   ├── fibo.java                # Fibonacci sequence generation
│   │   └── isDivisible.java         # Divisibility check (sum + product of digits)
│   │
│   ├── 📁 02-Arrays-And-Pointers/
│   │   ├── Max.java                 # Maximum element in array
│   │   ├── Minimum.java             # Minimum element in array
│   │   ├── Reverse.java             # In-place array reversal (Two Pointers)
│   │   └── Twosum.java              # Two Sum problem
│   │
│   ├── 📁 03-Searching-Algorithms/
│   │   ├── LinearSearch.java        # 1D & 2D Linear Search
│   │   ├── LinearSearchInString.java# Character search in String
│   │   ├── BinarySearch.java        # Order-Agnostic Binary Search (Overflow Prevention)
│   │   ├── GreaterOrEqualTo.java    # Ceiling and Floor in sorted array
│   │   ├── RangeOfNum.java          # First and Last position of element (LeetCode 34)
│   │   ├── MountainArray.java       # Peak index in Mountain/Bitonic Array
│   │   ├── MountainFind.java        # Search in Mountain/Bitonic Array (LeetCode 1095)
│   │   └── InfiniteArray.java       # Search in Infinite Sorted Array (Exponential Box Growth)
│   │
│   ├── 📁 04-Sorting-Algorithms/
│   │   ├── BubbleSort.java          # Sinking / Exchange Sort (O(N) best case optimization)
│   │   ├── SelectionSort.java       # Select & Place Sort (O(N) minimum swaps)
│   │   ├── InsertionSort.java       # Adaptive Insertion Sort
│   │   └── CyclicSort.java          # Cyclic Sort (1 to N index mapping)
│   │
│   ├── 📁 05-Cyclic-Sort-Pattern/
│   │   ├── FindMissing.java         # Find missing number in 0..N (LeetCode 268)
│   │   ├── FindPositiveMissing.java # First missing positive (LeetCode 41)
│   │   ├── FindRepeated.java        # Find duplicate number (LeetCode 287)
│   │   └── MisMatched.java          # Set Mismatch duplicate & missing pair (LeetCode 645)
│   │
│   └── 📁 06-2D-Arrays-And-Matrix/
│       ├── Multiarray.java          # 2D Matrix traversal & printing
│       ├── Search2D.java            # Staircase Search in Row & Column sorted matrix
│       ├── SortedMatrix.java        # Binary Search in Strictly Sorted 2D Matrix (4 Quadrants)
│       └── Solution.java            # Lucky Numbers in Matrix (LeetCode 1380)
│
├── 📁 02-Strings/                   # Future Topic
├── 📁 03-Recursion/                 # Future Topic
├── 📁 04-Linked-List/               # Future Topic
├── 📁 05-Stacks-And-Queues/         # Future Topic
├── 📁 06-Trees/                     # Future Topic
├── 📁 07-Graphs/                    # Future Topic
│
└── 📁 08-LeetCode-Solutions/        # Auto-pushed by LeetCode Browser Extension
```

---

## 📌 Procedure & Visual Diagram Format

Every algorithm program includes a comprehensive block comment (`/* ... */`) containing:
1. **`VISUAL / SYMBOLIC DIAGRAM`** – ASCII representation of pointers (`start`, `mid`, `end`), matrix quadrants, or mountain peak slopes.
2. **`STEP-BY-STEP PROCEDURE`** – Clear theoretical execution flow.
3. **`POINTER / INDEX ADJUSTMENT RATIONALE`** – Detailed rationale for index updates (`start = mid + 1`, `end = mid - 1`) preventing infinite loops.
4. **`EDGE CASE HANDLING`** – Handling boundary checks, 0-indexing, empty arrays, and variable copies (`originalNum`).
5. **`UNIQUE FORMULA & LOGIC`** – Math formulas (`mid = start + (end - start)/2`, `rem = num % 10`, `end = end + (end - start + 1) * 2`).

<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0001-two-sum](https://github.com/Saransh-27/DSA-JAVA/tree/master/0001-two-sum) |
| [0066-plus-one](https://github.com/Saransh-27/DSA-JAVA/tree/master/0066-plus-one) |
| [0162-find-peak-element](https://github.com/Saransh-27/DSA-JAVA/tree/master/0162-find-peak-element) |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
| [0442-find-all-duplicates-in-an-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0442-find-all-duplicates-in-an-array) |
| [0448-find-all-numbers-disappeared-in-an-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0448-find-all-numbers-disappeared-in-an-array) |
| [0645-set-mismatch](https://github.com/Saransh-27/DSA-JAVA/tree/master/0645-set-mismatch) |
| [0852-peak-index-in-a-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0852-peak-index-in-a-mountain-array) |
| [1095-find-in-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1095-find-in-mountain-array) |
| [1920-build-array-from-permutation](https://github.com/Saransh-27/DSA-JAVA/tree/master/1920-build-array-from-permutation) |
| [1929-concatenation-of-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1929-concatenation-of-array) |
| [2148-count-elements-with-strictly-smaller-and-greater-elements](https://github.com/Saransh-27/DSA-JAVA/tree/master/2148-count-elements-with-strictly-smaller-and-greater-elements) |
## Hash Table
|  |
| ------- |
| [0001-two-sum](https://github.com/Saransh-27/DSA-JAVA/tree/master/0001-two-sum) |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
| [0442-find-all-duplicates-in-an-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0442-find-all-duplicates-in-an-array) |
| [0448-find-all-numbers-disappeared-in-an-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0448-find-all-numbers-disappeared-in-an-array) |
| [0645-set-mismatch](https://github.com/Saransh-27/DSA-JAVA/tree/master/0645-set-mismatch) |
## Bit Manipulation
|  |
| ------- |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
| [0645-set-mismatch](https://github.com/Saransh-27/DSA-JAVA/tree/master/0645-set-mismatch) |
## Sorting
|  |
| ------- |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
| [0442-find-all-duplicates-in-an-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0442-find-all-duplicates-in-an-array) |
| [0645-set-mismatch](https://github.com/Saransh-27/DSA-JAVA/tree/master/0645-set-mismatch) |
| [2148-count-elements-with-strictly-smaller-and-greater-elements](https://github.com/Saransh-27/DSA-JAVA/tree/master/2148-count-elements-with-strictly-smaller-and-greater-elements) |
## Two Pointers
|  |
| ------- |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
## Binary Search
|  |
| ------- |
| [0162-find-peak-element](https://github.com/Saransh-27/DSA-JAVA/tree/master/0162-find-peak-element) |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
| [0852-peak-index-in-a-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0852-peak-index-in-a-mountain-array) |
| [1095-find-in-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1095-find-in-mountain-array) |
## Pigeonhole Principle
|  |
| ------- |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
## Floyd's Cycle Finding Algorithm
|  |
| ------- |
| [0287-find-the-duplicate-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0287-find-the-duplicate-number) |
## Math
|  |
| ------- |
| [0066-plus-one](https://github.com/Saransh-27/DSA-JAVA/tree/master/0066-plus-one) |
| [0268-missing-number](https://github.com/Saransh-27/DSA-JAVA/tree/master/0268-missing-number) |
## Interactive
|  |
| ------- |
| [1095-find-in-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1095-find-in-mountain-array) |
## Ternary Search
|  |
| ------- |
| [0852-peak-index-in-a-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/0852-peak-index-in-a-mountain-array) |
| [1095-find-in-mountain-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1095-find-in-mountain-array) |
## Counting
|  |
| ------- |
| [2148-count-elements-with-strictly-smaller-and-greater-elements](https://github.com/Saransh-27/DSA-JAVA/tree/master/2148-count-elements-with-strictly-smaller-and-greater-elements) |
## Simulation
|  |
| ------- |
| [1920-build-array-from-permutation](https://github.com/Saransh-27/DSA-JAVA/tree/master/1920-build-array-from-permutation) |
| [1929-concatenation-of-array](https://github.com/Saransh-27/DSA-JAVA/tree/master/1929-concatenation-of-array) |
<!---LeetCode Topics End-->