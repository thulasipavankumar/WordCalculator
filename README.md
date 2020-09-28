### latest build [![CircleCI](https://circleci.com/gh/thulasipavankumar/WordCalculator.svg?style=svg)](https://circleci.com/gh/thulasipavankumar/WordCalculator) |   master branch [![CircleCI](https://circleci.com/gh/thulasipavankumar/WordCalculator/tree/master.svg?style=svg)](https://circleci.com/gh/thulasipavankumar/WordCalculator/tree/master)
[![GitHub](https://img.shields.io/badge/issue_tracking-github-blue?logo=github)](https://github.com/thulasipavankumar/WordCalculator/issues)

### [download release binary jar](https://github.com/thulasipavankumar/WordCalculator/releases)
# Word Calculator 
The main objective of this project is to take a word as an input and give count of  permutation of dictionary defined 
words that can be formed by using  alphabets in the given word
### Implementation phase
- [x] Keep a file with all the words 
- [x] a logic to find out all the permuation of word that can be formed by using all the alphabets in a give word
- [x] after getting the permutation , match with dictonary words and if hit return them as a list
- [x] print the list as the final output 


1. Can permutate a string with less than 10 characters
2. Can check if the given word is a dictionary word or not 
3. Dictionary word support is  only given for alphabets

## To get the permutation of a given word
```
curl -X POST \
  https://wordjumble.herokuapp.com/permute \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"wordToPermutate":"hello"
}'
```

## To check if it is a dictionary word
```
curl -X POST \
  https://wordjumble.herokuapp.com/isDictionaryWord \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"word":"hello"
}'
```

