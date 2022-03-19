#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define STU_NUM		40	  			/* 最多的学生人数 */
#define COURSE_NUM	10				/* 最多的考试科目 */
struct student
{
	int		number;					/* 每个学生的学号 */
	char	name[10];              	/* 每个学生的姓名 */
	int		score[COURSE_NUM];		/* 每个学生M门功课的成绩 */
	int		sum;                   	/* 每个学生的总成绩 */
	float	average;               	/* 每个学生的平均成绩 */
};
typedef struct student STU;
/*  函数功能：	向链表的末尾添加从键盘输入学生的学号、姓名和成绩等信息
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量n，表示学生人数
				整型变量m，表示考试科目
	函数返回值：	无
*/
void AppendScore(STU *head, int n, int m)
{
	int		j;
	STU		*p;
	for (p=head; p<head+n; p++)
	{
		printf("\n请输入学号:");
		scanf("%d", &p->number);
		printf("请输入姓名:");
		scanf("%s", p->name);		
		for (j=0; j<m; j++)
		{
			printf("请输入分数%d:", j+1);
			scanf("%d", p->score+j);
		}
	}
}

/*	函数功能：	打印n个学生的学号、姓名和成绩等信息
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量n，表示学生人数
				整型变量m，表示考试科目
	函数返回值：	无
*/
void PrintScore(STU *head, int n, int m,FILE *fp)
{
	STU  *p;
	int  i;
	char str[100] = {'\0'}, temp[3];
	if(fp!=NULL){
		FileO();
	}
    else{
	
	for (i=1; i<=m; i++)
	{
	
		itoa(i,temp, 10);
		strcat(str, temp);
		strcat(str, " ");
	}

	         		/* 打印表头 */	
	for (p=head; p<head+n; p++)  	/* 打印n个学生的信息 */
	{
		printf("\n%d        %s", p->number, p->name);		
		for (i=0; i<m; i++)
		{
			printf("       %d", p->score[i]);
		}
		printf("    %d(总分)         %2f（平均分）\n", p->sum, p->average);
	}
}
}

/* 	函数功能：	计算每个学生的m门功课的总成绩和平均成绩
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量n，表示学生人数
				整型变量m，表示考试科目
	函数返回值：	无
*/
void  TotalScore(STU *head, int n, int m,FILE *fp)
{
	STU   *p;
	int   i,j;
	for (p=head; p<head+n; p++)
	{
		p->sum = 0;
		for (i=0; i<m; i++)
		{
			p->sum = p->sum + p->score[i];
		}		
		p->average = (float)p->sum / m;
	}
}

/* 	函数功能：	用选择法按总成绩由高到低排序
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量n，表示学生人数
	函数返回值：	无
*/
void  SortScore(STU *head, int n,FILE*fp)
{
	int  i, j, k;
	STU  temp;
	for (i=0; i<n-1; i++)
	{
		k = i;
		for (j=i; j<n; j++)
		{
			if ((head+j)->sum > (head+k)->sum)
			{
				k = j;
			}
		}
		if (k != i)
		{
			temp = *(head+k);
			*(head+k) = *(head+i);
			*(head+i) = temp;
		}
   	}
}

/* 	函数功能：	查找学生的学号
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量num，表示要查找的学号
				整型变量n，表示学生人数
	函数返回值：	如果找到学号，则返回它在结构体数组中的位置，否则返回-1
*/
int SearchNum(STU *head, int num, int n,FILE *fp)
{
	int i;
	for (i=0; i<n; i++)
	{
		if ((head+i)->number == num)	return i;
	}
	return -1;
}

/* 	函数功能：	按学号查找学生成绩并显示查找结果
	函数参数：	结构体指针head，指向存储学生信息的结构体数组的首地址
				整型变量n，表示学生人数
				整型变量m，表示考试科目
	函数返回值：	无
*/
void SearchScore(STU *head, int n, int m,FILE *fp)
{
	int number, findNo;
	int i,j=0;
	printf("输入学号进行查找:"); 	
	scanf("%d", &number);
	findNo = SearchNum(head, number, n,fp);
	if (findNo == -1)
	{
		printf("\n未查询到对应学号!\n");
	}
	else
	{
		PrintScore(head+findNo, 1, m,fp);
	}
}
//函数功能：读写文件 
int FileW(STU *head, int n, int m){
	FILE *fp,*fp1;
	char ch;
	fp=fopen("D:\\student.txt","wb");//r表示读文件，w表示写文件  
	if(fp==NULL){
		printf("文件打开失败"); 
	}
	int i=0;
	STU  *p;
	fprintf(fp,"%d\t%d\n",n,m);
	for (p=head; p<head+n; p++)
	{    	   
	   	fprintf(fp,"%7d",p->number);
	   	fprintf(fp,"%7s",p->name);
		for (i=0; i<m; i++)
		{ 
		fprintf(fp,"%5d",p->score[i]);	  
		}		
	}
	fclose(fp);
	fp1=fopen("D:\\student.txt","rb");
	if(fp1==NULL){
		printf("文件打开失败"); 
	}
	while((ch=fgetc(fp1))!=EOF){
	    putchar(ch);
	} 
	fclose(fp1);
}
void FileO(){//读出函数 
	FILE *fp1;
	char ch;
	fp1=fopen("D:\\student.txt","rb");
	if(fp1==NULL){
		printf("文件打开失败"); 
	}
	while((ch=fgetc(fp1))!=EOF){
	    putchar(ch);
	} 
	fclose(fp1);
}
void RE(FILE *fp,STU *head, int *n, int *m){//把数据从student.txt中读到结构体数组中 
	int i,j;
	fscanf(fp,"%d\t%d",n,m);
	for(i=0;i<*n;i++){
		fscanf(fp,"%7d",&head->number);
		fscanf(fp,"%7s",&head->name);
		for(j=0;j<*m;j++){
			fscanf(fp,"%5d",&head->score[j]);
		}		
	}
	fclose(fp);
}
/*	函数功能：	显示菜单并获得用户键盘输入的选项
	函数参数：	无
	函数返回值：	用户输入的选项
*/
char Menu(void)
{
	char ch;
	printf("\n欢迎使用学生管理系统\n");
	printf(" 1.输入学生记录\n");
	printf(" 2.显示学生成绩\n");
	printf(" 3.查找学生成绩\n");
	printf(" 4.成绩排名\n");
	printf(" 5.写入文件\n");
	printf(" 6.读出文件\n");	
	printf(" 0.退出程序\n");
	printf("您的选择是:");
	scanf(" %c", &ch); /*在%c前面加一个空格，将存于缓冲区中的回车符读入*/
	return ch;
}
main()                           				
{
	char	ch;
	int		m=1, n=3;
	STU 	stu[STU_NUM];
	FILE *fp;
    fp=fopen("D:\\student.txt","rb");
	while (1)
	{
		ch = Menu();					    /* 显示菜单，并读取用户输入 */
		switch (ch)
		{
			case'1':printf("请输入学生总数和课程科目总数：(n<40,m<10):");
                    scanf("%d %d", &n, &m);
			        AppendScore(stu, n, m);/* 调用成绩添加模块 */
					break;
			case'2':PrintScore(stu, n, m,fp); /* 调用成绩显示模块 */
						break;
			case'3':SearchScore(stu, n, m,fp);/* 调用按学号查找模块 */
						break;
			case'4':SortScore(stu, n,fp);      /* 调用成绩排序模块 */
						printf("\n排序结果\n");
						PrintScore(stu, n, m,fp);	/* 显示成绩排序结果 */
						break;	
			case '5':FileW(stu, n,  m);
			            break;
			case '6':FileO(stu, n,  m);
			            break;		 
			case'0':exit(0);                  /* 退出程序 */
						printf("退出程序!");
			       	    break;
			default:printf("输入错误!");
						break;
		}		
	}
}
