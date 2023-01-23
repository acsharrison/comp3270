# include <stdio.h>
# include <math.h>
# include <time.h>


int main() {
    clock_t start, stop;
    double duration;
    start = clock();

    int sum = 0;
    int n = 0;
    int x = 0;
    int a = 0;

    printf("enter value for a: ");
    scanf("%d",&a);
    printf("enter value for x: ");
    scanf("%d",&x);
    printf("enter value for n: ");
    scanf("%d",&n);

    for (int i = 1; i <= n; i++) {
        sum += pow(x,i);
    }
    sum += 1;
    stop = clock();
     duration = (double) (stop - start) / CLOCKS_PER_SEC;
     printf("%d", a*sum);
    printf( "\nThe number of seconds for loop to run was %.10lf\n", duration);
    return 0;
}
