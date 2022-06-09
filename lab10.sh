touch username.txt
echo "xxx21" >> username.txt
echo "xyxzw" >> username.txt 
echo "vveeww1" >> username.txt 
echo "xy123" >> username.txt 

touch grades.txt
echo "xxx21 100" >> grades.txt
echo "xyxzw 90" >> grades.txt 
echo "vww1 85" >> grades.txt
echo "vveeww1 80" >> grades.txt
echo "xy123 70" >> grades.txt

while read username
    do
        while read usern grades
            do
                if [[ $username == $usern ]]; then
                    > $usern.txt
                    echo "Dear $usern," > $usern.txt
                    echo "Your grade for this exam is $grades." >> $usern.txt
                fi
        done < grades.txt
    done < username.txt