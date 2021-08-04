#!/bin/bash

echo -n "Enter count of characters:"
read count

mkdir "dir1"
touch "dir1/long_names.txt"
mkdir "dir2"
touch "dir2/short_names.txt"
echo "Dir created"

filename=$(find ./* -name "*.java")
echo "$filename"
for everyname in $filename; do
   shortname=$(basename "$everyname" .java)
   echo ${#shortname}
	if [[ "${#shortname}" -ge "$count" ]]; then
	   echo $(basename "$everyname") >> dir1/long_names.txt
	else
	   echo $(basename "$everyname") >> dir2/short_names.txt
	fi
done
