# Java Algorithm Practice

Solutions to [Exercism](https://exercism.org/tracks/java) Java track exercises — 34 exercises covering strings, algorithms, OOP, data structures, and concurrency.

## Exercises

### Strings & Text
| Exercise | Description |
|---|---|
| [Acronym](java/acronym) | Convert a phrase to its acronym |
| [Atbash Cipher](java/atbash-cipher) | Encode and decode text using the Atbash cipher |
| [Bottle Song](java/bottle-song) | Generate the lyrics to "Ten Green Bottles" |
| [Isogram](java/isogram) | Check if a word has no repeating letters |
| [Pangram](java/pangram) | Check if a sentence uses every letter of the alphabet |
| [Phone Number](java/phone-number) | Parse and clean NANP phone numbers |
| [Proverb](java/proverb) | Generate a proverb from a list of words |
| [Reverse String](java/reverse-string) | Reverse a string |
| [Rotational Cipher](java/rotational-cipher) | Encrypt and decrypt text with a rotational cipher |
| [Twelve Days](java/twelve-days) | Generate the lyrics to "The Twelve Days of Christmas" |
| [Word Count](java/word-count) | Count the frequency of each word in a text |

### Arrays & Collections
| Exercise | Description |
|---|---|
| [Flatten Array](java/flatten-array) | Flatten a deeply nested list structure |
| [Gotta Snatch 'Em All](java/gotta-snatch-em-all) | Set operations on card collections |
| [High Scores](java/high-scores) | Track and query a leaderboard of scores |
| [Secret Handshake](java/secret-handshake) | Decode a binary number into a sequence of actions |

### OOP & Design
| Exercise | Description |
|---|---|
| [Annalyn's Infiltration](java/annalyns-infiltration) | Boolean logic for game character actions |
| [Bird Watcher](java/bird-watcher) | Array statistics for daily bird counts |
| [Cars Assemble](java/cars-assemble) | Floating-point arithmetic for production rate calculations |
| [Lasagna](java/lasagna) | Constants and cooking time calculations |
| [Tim from Marketing](java/tim-from-marketing) | String formatting with nullable fields |
| [Wizards & Warriors](java/wizards-and-warriors) | Abstract classes and inheritance |
| [Wizards & Warriors 2](java/wizards-and-warriors-2) | Method overloading |

### Algorithms
| Exercise | Description |
|---|---|
| [All Your Base](java/all-your-base) | Convert numbers between arbitrary bases |
| [Diamond](java/diamond) | Print a diamond letter pattern as ASCII art |
| [Flower Field](java/flower-field) | Count adjacent mines on a board (Minesweeper variant) |
| [Largest Series Product](java/largest-series-product) | Find the largest product of consecutive digits in a string |
| [Matching Brackets](java/matching-brackets) | Validate balanced brackets using a stack |

### Data Structures & Systems
| Exercise | Description |
|---|---|
| [Graph Search](java/graph-search) | BFS and DFS graph traversal |
| [Rate Limiter](java/rate-limiter) | Token bucket rate-limiting with Java locks |
| [Relative Distance](java/relative-distance) | Compute degrees of separation in a graph |
| [Robot Simulator](java/robot-simulator) | Simulate a robot navigating a grid with cardinal directions |
| [Split-Second Stopwatch](java/split-second-stopwatch) | Concurrent stopwatch with split times |

### Fundamentals
| Exercise | Description |
|---|---|
| [Error Handling](java/error-handling) | Checked and unchecked exceptions |
| [Hello World](java/hello-world) | The classic first exercise |

## Running exercises

Run all exercises from the root:

```bash
./gradlew test
```

Run a single exercise:

```bash
./gradlew :java:<exercise-name>:test
```
