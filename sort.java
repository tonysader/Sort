package sortbubleinsertselect;

class ar{
    private long[] a; //The array
    private int n;//length of the array
    public ar(int max){
        a = new long[max];
        n=0;
    }
    public void insert(long val){
        a[n] = val;
        n++;
    }
    public void display(){
        for(int i=0;i<n;i++)
            System.out.print(a[i] + " ");
    }
    public void swap(int idx1,int idx2){
        long temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
    public void bubbleSort(){
        int in,out;
        for( out= n-1;out>0;out--){
            for(in = 0 ; in < out ;in++){
                long z = a[in];
                long zo = a[in+1];
                if(a[in] > a[in+1])
                    swap(in,in+1);
            }
        }
        
    }
    public void selectionSort(){
        int min,in,out;
        for(out=0;out<n;out++){
            min = out;
            for(in=out+1;in<n;in++){
                if(a[in] < a[min])
                    min = in;
            }
            int z = min;// just for debugging
            swap(out,min);
        }
    }
    
    public void insertionSort(){
        int in,out;
        for(out=1;out<n-1;out++){
            long temp = a[out];
            in = out;
            while(in>0 && a[in-1]>=temp){
                a[in] = a[in-1];
                in--;
            }
            a[in] = temp;
        }
    }
    public void shellSort(){
        int in,out; long temp;
        int h = 1;
        while(h<= n/3) h = h * 3 +1;
        while(h> 0){
            for(out =h; out < n;out++){
                temp = a[out];
                in = out;
                while(in > h-1 && a[in - h] >= temp){
                    a[in] = a[in-h];
                    in -= h;
                }
                a[in] = temp;
            }
            h = (h-1)/3;
        }
    }
    
    public void mergeSort(){
        long[] temp = new long[n];
        mergeSort(temp,0,n-1);
    }
    public void mergeSort(long[] temp,int lowerBound , int upperBound){
        if(lowerBound == upperBound)
            return;
        int mid = (lowerBound + upperBound)/2;
        mergeSort(temp,lowerBound,mid);
        mergeSort(temp,mid+1,upperBound);
        merge(lowerBound,mid+1,upperBound,temp);
    }
    public void merge(int lowPtr,int highPtr,int upperBound,long[] temp){
        int j=0;
        int mid = highPtr - 1;
        int lowerBound = lowPtr;
        int size = upperBound - lowerBound + 1;
        while(lowPtr <= mid && highPtr <= upperBound){
            if(a[lowPtr] < a[highPtr])
                temp[j++] = a[lowPtr++];
            else
                temp[j++] = a[highPtr++];
        }
        while(lowPtr <= mid)
            temp[j++] = a[lowPtr++];
        while(highPtr <= upperBound)
            temp[j++] = a[highPtr++];
        for(int i=0;i<size;i++)
            a[lowerBound + i] = temp[i];
    }
    
    public void quickSort(){
        quickSort(0,n-1);
    }
    public void quickSort(int left,int right){
        if(left >= right)
            return;
        long pivot = a[right];
        int partition = partIt(left,right,pivot);
        quickSort(left,partition -1);
        quickSort(partition+1,right);
    }
    public int partIt(int left,int right,long pivot){
        int leftPtr = left -1;
        int rightPtr = right;
        while(true){
            while(a[++leftPtr] < pivot);
            while(a[--rightPtr] > pivot);
            if(leftPtr >= rightPtr) break;
            else
                swap(leftPtr,rightPtr);
        }
        swap(leftPtr,right);
        return leftPtr;
    }
    
    public void quickSort3(){
        quickSort3(0,n-1);
    }
    public void quickSort3(int left,int right){
        int size = right  - left +1;
        if(size <= 3) manualSort(left,right,size);
        else{
        long pivot = medianOf3(left,right);
        int partition = partIt3(left,right,pivot);
        quickSort3(left,partition -1);
        quickSort3(partition+1,right);
        }
    }
    public int partIt3(int left,int right,long pivot){
        int leftPtr = left;
        int rightPtr = right -1;
        while(true){
            while(a[++leftPtr] < pivot);
            while(a[--rightPtr] > pivot);
            if(leftPtr >= rightPtr) break;
            else
                swap(leftPtr,rightPtr);
        }
        swap(leftPtr,right-1);
        return leftPtr;
    }
    public long medianOf3(int left,int right){
        int center= (left + right ) /2;
        if(a[left] > a[center]){
            swap(left,center);
        }
        if(a[left] > a[right]){
            swap(left,right);
        }
        if(a[center] > a[right])
            swap(center , right);
        swap(center,right-1);
        return a[right-1];
    }
    public void manualSort(int left,int right,int size){
        if(size <= 1)
            return;
        else if(size == 2){
            if(a[left] > a[right])
                swap(left,right);
            return;
        }
        else if(size == 3){
            if(a[left] > a[right - 1])
                swap(left,right-1);
            if(a[left] > a[right])
                swap(left,right);
            if(a[right - 1] > a[right])
                swap(right-1,right);
            return;
        }
        
     
    }
}
public class sort {
    public static void main(String[] args) {
        ar myArray = new ar(100);
        myArray.insert(5);
        myArray.insert(1);
        myArray.insert(-5);
        myArray.insert(3);
        
        System.out.println("Before sort:");
        myArray.display();
        System.out.println();
        //System.out.println("After bubble sort:");
        //myArray.bubbleSort();
        //System.out.println("After selection sort:");
        //myArray.selectionSort();
        //System.out.println("After insertion sort:");
        //myArray.insertionSort();
  //      System.out.println("After Merge sort:");
//        myArray.mergeSort();
      //  System.out.println("After Shell sort:");
    //    myArray.shellSort();
        //System.out.println("After quick sort:");
        //myArray.quickSort();
        System.out.println("After quick sort 3:");
        myArray.quickSort3();
        
        myArray.display();
        System.out.println();

        
        
    }
    
}
