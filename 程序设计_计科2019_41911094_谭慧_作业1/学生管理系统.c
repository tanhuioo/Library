#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define STU_NUM		40	  			/* ����ѧ������ */
#define COURSE_NUM	10				/* ���Ŀ��Կ�Ŀ */
struct student
{
	int		number;					/* ÿ��ѧ����ѧ�� */
	char	name[10];              	/* ÿ��ѧ�������� */
	int		score[COURSE_NUM];		/* ÿ��ѧ��M�Ź��εĳɼ� */
	int		sum;                   	/* ÿ��ѧ�����ܳɼ� */
	float	average;               	/* ÿ��ѧ����ƽ���ɼ� */
};
typedef struct student STU;
/*  �������ܣ�	�������ĩβ��ӴӼ�������ѧ����ѧ�š������ͳɼ�����Ϣ
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���n����ʾѧ������
				���ͱ���m����ʾ���Կ�Ŀ
	��������ֵ��	��
*/
void AppendScore(STU *head, int n, int m)
{
	int		j;
	STU		*p;
	for (p=head; p<head+n; p++)
	{
		printf("\n������ѧ��:");
		scanf("%d", &p->number);
		printf("����������:");
		scanf("%s", p->name);		
		for (j=0; j<m; j++)
		{
			printf("���������%d:", j+1);
			scanf("%d", p->score+j);
		}
	}
}

/*	�������ܣ�	��ӡn��ѧ����ѧ�š������ͳɼ�����Ϣ
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���n����ʾѧ������
				���ͱ���m����ʾ���Կ�Ŀ
	��������ֵ��	��
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

	         		/* ��ӡ��ͷ */	
	for (p=head; p<head+n; p++)  	/* ��ӡn��ѧ������Ϣ */
	{
		printf("\n%d        %s", p->number, p->name);		
		for (i=0; i<m; i++)
		{
			printf("       %d", p->score[i]);
		}
		printf("    %d(�ܷ�)         %2f��ƽ���֣�\n", p->sum, p->average);
	}
}
}

/* 	�������ܣ�	����ÿ��ѧ����m�Ź��ε��ܳɼ���ƽ���ɼ�
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���n����ʾѧ������
				���ͱ���m����ʾ���Կ�Ŀ
	��������ֵ��	��
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

/* 	�������ܣ�	��ѡ�񷨰��ܳɼ��ɸߵ�������
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���n����ʾѧ������
	��������ֵ��	��
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

/* 	�������ܣ�	����ѧ����ѧ��
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���num����ʾҪ���ҵ�ѧ��
				���ͱ���n����ʾѧ������
	��������ֵ��	����ҵ�ѧ�ţ��򷵻����ڽṹ�������е�λ�ã����򷵻�-1
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

/* 	�������ܣ�	��ѧ�Ų���ѧ���ɼ�����ʾ���ҽ��
	����������	�ṹ��ָ��head��ָ��洢ѧ����Ϣ�Ľṹ��������׵�ַ
				���ͱ���n����ʾѧ������
				���ͱ���m����ʾ���Կ�Ŀ
	��������ֵ��	��
*/
void SearchScore(STU *head, int n, int m,FILE *fp)
{
	int number, findNo;
	int i,j=0;
	printf("����ѧ�Ž��в���:"); 	
	scanf("%d", &number);
	findNo = SearchNum(head, number, n,fp);
	if (findNo == -1)
	{
		printf("\nδ��ѯ����Ӧѧ��!\n");
	}
	else
	{
		PrintScore(head+findNo, 1, m,fp);
	}
}
//�������ܣ���д�ļ� 
int FileW(STU *head, int n, int m){
	FILE *fp,*fp1;
	char ch;
	fp=fopen("D:\\student.txt","wb");//r��ʾ���ļ���w��ʾд�ļ�  
	if(fp==NULL){
		printf("�ļ���ʧ��"); 
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
		printf("�ļ���ʧ��"); 
	}
	while((ch=fgetc(fp1))!=EOF){
	    putchar(ch);
	} 
	fclose(fp1);
}
void FileO(){//�������� 
	FILE *fp1;
	char ch;
	fp1=fopen("D:\\student.txt","rb");
	if(fp1==NULL){
		printf("�ļ���ʧ��"); 
	}
	while((ch=fgetc(fp1))!=EOF){
	    putchar(ch);
	} 
	fclose(fp1);
}
void RE(FILE *fp,STU *head, int *n, int *m){//�����ݴ�student.txt�ж����ṹ�������� 
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
/*	�������ܣ�	��ʾ�˵�������û����������ѡ��
	����������	��
	��������ֵ��	�û������ѡ��
*/
char Menu(void)
{
	char ch;
	printf("\n��ӭʹ��ѧ������ϵͳ\n");
	printf(" 1.����ѧ����¼\n");
	printf(" 2.��ʾѧ���ɼ�\n");
	printf(" 3.����ѧ���ɼ�\n");
	printf(" 4.�ɼ�����\n");
	printf(" 5.д���ļ�\n");
	printf(" 6.�����ļ�\n");	
	printf(" 0.�˳�����\n");
	printf("����ѡ����:");
	scanf(" %c", &ch); /*��%cǰ���һ���ո񣬽����ڻ������еĻس�������*/
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
		ch = Menu();					    /* ��ʾ�˵�������ȡ�û����� */
		switch (ch)
		{
			case'1':printf("������ѧ�������Ϳγ̿�Ŀ������(n<40,m<10):");
                    scanf("%d %d", &n, &m);
			        AppendScore(stu, n, m);/* ���óɼ����ģ�� */
					break;
			case'2':PrintScore(stu, n, m,fp); /* ���óɼ���ʾģ�� */
						break;
			case'3':SearchScore(stu, n, m,fp);/* ���ð�ѧ�Ų���ģ�� */
						break;
			case'4':SortScore(stu, n,fp);      /* ���óɼ�����ģ�� */
						printf("\n������\n");
						PrintScore(stu, n, m,fp);	/* ��ʾ�ɼ������� */
						break;	
			case '5':FileW(stu, n,  m);
			            break;
			case '6':FileO(stu, n,  m);
			            break;		 
			case'0':exit(0);                  /* �˳����� */
						printf("�˳�����!");
			       	    break;
			default:printf("�������!");
						break;
		}		
	}
}
