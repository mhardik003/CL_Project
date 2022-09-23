from asyncore import read
from typing import final


input = '/home/asus/Desktop/IIIT/sem 2/CL/PROJECT_PART2/output.txt'
c = open(input, "r")
corpus=c.read()
final_corpus=""
corpuss=corpus.splitlines()
# print(corpuss[2])
for i in range(len(corpuss)-2):
    if corpuss[i]=="----------------------------------":
        final_corpus=final_corpus+corpuss[i+2]+"\n"


k = open("input_for_part_B.txt", "w")
k.write(final_corpus)

