clear
mkdir 
218215210_amsal_ali
rm helloWorld.c
code helloWorld.c
echo "#include <stdio.h>" >> helloWorld.c
echo 'int main() {
    printf("%s\n", "Hello World");
    return 0;
}' >> helloWorld.c
gcc helloWorld.c
touch lab9.txt
./a.out > lab9.txt
echo "***************" >> lab9.txt
date +"Date = %m-%d-%Y%n%H:%M:%S" >> lab9.txt
echo "***************" >> lab9.txt
wc -w lab9.txt | awk '{$1=$1; print}' >> lab9.txt
echo "***************" >> lab9.txt
cat lab9.txt > lab9a.txt
grep -w "hello world" lab9.txt >> lab9.txt
grep -w "Hello World" lab9.txt >> lab9.txt
echo "***************" >> lab9.txtcs
diff lab9a.txt lab9.txt >> lab9.txt
echo "***************" >> lab9.txt
chmod 624 lab9.txt
ls -l lab9.txt >> lab9.txt
echo "***************" >> lab9.txt