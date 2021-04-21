#include <stdio.h>
#include <time.h>
#include <stdlib.h>

const int ARRAY_SIZE = 1000;

void subscripting() {
  int arr[ARRAY_SIZE][ARRAY_SIZE];
  int x;
  for (int i = 0; i < ARRAY_SIZE; i++) {
    x = arr[i][i];
  }
}

void pointer() {
  int arr[ARRAY_SIZE][ARRAY_SIZE];
  int x;
  for (int i = 0; i < ARRAY_SIZE; i++) {
    int *p = *(arr + i);
    x = *(p + i);
  }
}

int main() {
  struct timespec tStart, tEnd;
  // Subscripting
  clock_gettime(CLOCK_REALTIME, &tStart);
  subscripting();
  clock_gettime(CLOCK_REALTIME, &tEnd);
  printf("Subscripting: %ld nano seconds\n", tEnd.tv_nsec - tStart.tv_nsec);
  // Pointer
  clock_gettime(CLOCK_REALTIME, &tStart);
  pointer();
  clock_gettime(CLOCK_REALTIME, &tEnd);
  printf("Pointer: %ld nano seconds\n", tEnd.tv_nsec - tStart.tv_nsec);

}
