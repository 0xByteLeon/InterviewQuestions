import os
'''
2018.4.18 杭州绿湾面试题目
ios切图文件过滤，删除2x文件，并重命名3x文件，代码实现
'''
rootdir = input("请输入资源文件根目录:")

for parent, dirs, filenames in os.walk(rootdir):
    # for dirname in dirs:  # 输出文件夹信息
    #     print("parent is:" + parent)
    #     print("dirname is" + dirname)
    for filename in filenames:  # 输出文件信息
        print("parent-file is:" + parent)
        print("filename is:" + filename)
        print("the full name of the file is:" + os.path.join(parent, filename))

        currentfile = os.path.join(parent, filename)
        if currentfile.endswith("@2x.jpg"):
            os.remove(os.path.join(parent, filename))
        elif currentfile.endswith("@3x.jpg"):
            os.rename(currentfile, os.path.join(rootdir, currentfile.replace("@3x", "")))