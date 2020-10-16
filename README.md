# InterviewQuestions
### COS 226: Fall 2020
COS 226 Precept P07 - Fall 2020
All proposed interview questions along with solutions.

Each week, I'll post an implemented solution for a common interview problem I've either encountered or given to others.

- [Crime Scene](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L34): Given a list of heights in a line where the front of the line is at the end of the array, return the number of people tall enough to see the front of the line. In order to be tall enough, the person must be taller than all of the people in front of them.

- [Stack with Queues](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L79) [(Leetcode)](https://leetcode.com/problems/implement-stack-using-queues/): Implement a stack only using queues. You may only use a maximum of two queues and must assume FIFO ordering (not a doubly-linked list).

- [Fill Backpack with Nearby Toys](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L163): Given a list of toy weights and the capacity of a backpack, find the maximum number of toys you can fit within the backpack. You may only grab 1 contiguous sequence of toys.

- [Min Remove Parentheses for Valid String](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L220) [(Leetcode)](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/): Given a string, return the same string with the minimum amount of unnecessary parentheses removed to make the string valid.

- [Min. Required Meeting Rooms](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L275) [(Leetcode)](https://www.lintcode.com/problem/meeting-rooms-ii/description): Given a list of meetings (denoted by their start/end times) asking for a room, return the minimum number of rooms required to accommodate all meetings.

- [Are Anagrams](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L361) [(Leetcode)](http://leetcode.com/problems/valid-anagram/): Given two words, determine whether or not they are [anagrams](https://en.wikipedia.org/wiki/Anagram).

- [Group Anagrams](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA20.java#L396) [(Leetcode)](http://leetcode.com/problems/group-anagrams/): Given a list of words, group them based on whether they are [anagrams](https://en.wikipedia.org/wiki/Anagram).

---
### COS 226: Spring 2020

COS 226 Precept P04A Spring 2020 - All interview questions of the day with solutions

Each week, I'll post the solution to a common interview problem I've either encountered or given to candidates. I'll try and keep the list of problems below up to date!

- [Max Profit for Single Stock Trade](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L33) ([Leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)): Given a list of stock prices over a series of days, find the maximum profit possible by executing a single trade (one buy and one sell).

- [Apartment Ocean View](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L67): Given a list of building heights, suppose there is an ocen view at the end of the array. A building has an ocean view if its height is greater than all buildings between it and the ocean. Count the number of buildings with an ocean view.

- [Merge Intervals](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L100) ([Leetcode](https://leetcode.com/problems/merge-intervals/)): Given a list of intervals of the form `[startTime, endTime]` that may or may not be overlapping, merge any overlapping intervals.

- [Product Excluding Self](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L143) ([Leetcode](https://leetcode.com/problems/product-of-array-except-self/)): Given a list of numbers, return an array where `output[i]` is the product of all the numbers in the list except `nums[i]`. Main challenge: can you do this without division and using linear time with constant space?

- [k-Nearest Restaurants](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L179):Given a list of xy-coordinates of restaurants and a coordinate for a home, return the k-nearest restaurants to the home.

- [k Most Frequent Words](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L272): Given a (potentially very large) corpus string of space-separated words and a list of skip words to omit, return the k-most frequently occurring words that do not appear in the list of omitted words.

- [Number of Islands](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L321) ([Leetcode](https://leetcode.com/problems/number-of-islands/)): Given a grid of 0s and 1s, return the number of unique islands there are (1 being land and 0 being ocean). Assume the grid edges are the ocean and land connections can only be adjacent non-diagonally (up, down, left, right).

- [Min Word Transform](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L397) ([Leetcode](https://leetcode.com/problems/word-ladder/)): Given two words and a list of all possible words, find the minimum number of operations to convert from the start word to the end word using only words in wordList. Each transformation changes a single character at a time.

- [LRU Cache](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsSP20.java#L464) ([Leetcode](https://leetcode.com/problems/lru-cache/)): Given a positive capacity, design an LRU cache that supports `get(key)` operations and `put(key, value)` operations in constant time.

---
### COS 226: Fall 2019
COS 226 Precept P02 Fall 2019 - All Interview Questions of the Day (IQODs)

Each week, I'll post the solution to a common interview problem I've either encountered or given to candidates. I'll try and keep the list of problems below up to date!

- [validAnagrams](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L16) ([Leetcode](https://leetcode.com/problems/valid-anagram/)): Given two strings, return true iff they are [anagrams](https://en.wikipedia.org/wiki/Anagram) and false otherwise.

- [validParentheses](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L49) ([Leetcode](https://leetcode.com/problems/valid-parentheses/)): Given a string of parentheses, brackets, and braces, return true the expression is valid (i.e. all opening characters have the correct closing character). False otherwise.

- [simplifyFilePath](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L87) ([Leetcode](https://leetcode.com/problems/simplify-path/)): Given an absolute file path, convert it to the shortest possible absolute file path that points to the same directory.

- [minWordTransform](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L140) ([Leetcode](https://leetcode.com/problems/word-ladder/)): Given a start word, end word, and list of valid intermediate words, return the minimum length transformation to convert the start word one letter at a time into the end word using only valid intermediate words.

- [cheapestFlightsWithLayovers](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L215) ([Leetcode](https://leetcode.com/problems/cheapest-flights-within-k-stops/)): Given the number of cities, a list of available flights, a start city, an end city, and a maximum number of layovers, find the cost of the cheapest flight sequence to get from the start city to the end city within the layover limit. 

- [LRU Cache](https://github.com/cdsciavolino/InterviewQuestions/blob/master/src/SolutionsFA19.java#L260) ([Leetcode](https://leetcode.com/problems/lru-cache/)): Given a capacity, implement an LRU cache that supports `put(key, value)` and `get(key)` in constant time.
