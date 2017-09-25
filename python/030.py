'''
Problem Statement:

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
'''

n = 5
s = 0

for num in range(10, 10**(n+1)-1):
	val = sum([int(j)**n for j in str(num)])
	if val == num:
		s += val

print(s)