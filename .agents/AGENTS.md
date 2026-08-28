# Project Rules

- Whenever adding pseudo-code or procedure comments to a Java program file:
  1. Add a block comment (`/* ... */`) at the very end (last lines) of the file.
  2. Structure the comment into clear, revision-friendly sections where relevant:
     - `VISUAL / SYMBOLIC DIAGRAM` (ASCII visual representation of array, pointers like start/mid/end, matrix, or mountain peak for instant visual revision)
     - `STEP-BY-STEP PROCEDURE` (concise step-by-step flow)
     - `POINTER / INDEX ADJUSTMENT RATIONALE` (explaining `start = mid + 1`, `end = mid - 1` to exclude checked indices and prevent infinite loops)
     - `EDGE CASE HANDLING` (explaining variable copies like `originalNum` or zero/boundary checks)
     - `UNIQUE FORMULA & LOGIC` (only explaining math/formulas unique or uncommon to the program; avoid repeating standard boilerplate across files)
  3. For complex algorithms (e.g., 2D matrix binary search, mountain peak search, infinite array expansion), include detailed quadrant selection logic, two-phase search rationale, or step-by-step matrix reduction diagrams.
  4. Ensure explanations are simple, clear, visual, and optimized for fast future revision.




