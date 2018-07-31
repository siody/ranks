package siody.exams;

import org.apache.commons.math3.random.RandomDataGenerator;

public class Abrank {
    static public void main(String[] args) {
        char[] toSort = {'a','b','b'};
        Table[] linkTable = new Table[toSort.length];
        int pointToInsert = 0;
        long randomlong = new RandomDataGenerator().nextLong(10L,20L);
        for (int i=0;i<toSort.length;++i) {
            boolean containFlag = false;
            for (int j=0;linkTable[j]!=null && j<pointToInsert;++j){
                if (linkTable[j].value==toSort[i]){
                    linkTable[j].addNum();
                    containFlag = true;
                    break;
                }
            }
            if (!containFlag){
                linkTable[pointToInsert++] = new Table(toSort[i]);
            }
        }
    }
}

class Table {
    char value;
    int num;
    Table(char _value) {
        this.value=_value;
        this.num=1;
    }
    public void addNum() {
        num+=1;
    }
}
