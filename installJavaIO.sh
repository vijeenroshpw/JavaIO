#/bin/sh
#Vijeenrosh P.W <hsorhteeniv@gmail.com>
#The script will download and configure the Simple JavaIO

#downloading the tar 

wget -P ~/Downloads/ http://github.com/vijeenroshpw/JavaIO/tarball/master 
mv ~/Downloads/master ~/Downloads/master.tar.gz
#extracting the package
cd ~/Downloads/
tar -xvf ~/Downloads/master.tar.gz
mkdir ~/JLibrary
mkdir ~/JLibrary/IO
cp ~/Downloads/vijeenroshpw-JavaIO-264eafd/IO/IO.class ~/JLibrary/IO
cp ~/Downloads/vijeenroshpw-JavaIO-264eafd/IO/IO.java ~/JLibrary/IO
#btree is a sample programme , used to test input output
cp ~/Downloads/vijeenroshpw-JavaIO-264eafd/btree.java ~/JLibrary/
#updates the .bashrc
echo "export CLASSPATH=$CLASSPATH:~/JLibrary" >> ~/.bashrc
#happy hacking :)



