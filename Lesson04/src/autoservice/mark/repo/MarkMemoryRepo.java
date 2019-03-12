package autoservice.mark.repo;

import autoservice.common.ArrayUtils;
import autoservice.mark.Mark;

import static autoservice.storage.Storage.marks;

public class MarkMemoryRepo {

    private int markIndex = -1;

    public void addMark(Mark mark) {
        if (markIndex == marks.length - 1) {
            Mark[] newArrMarks = new Mark[marks.length * 2];
            System.arraycopy(marks, 0, newArrMarks, 0, marks.length);
            marks = newArrMarks;
        }

        markIndex++;
        marks[markIndex] = mark;
    }

    public Mark findMarkById(long id) {
        Integer foundIndex = findMarkIndexById(id);
        if (foundIndex != null) {
            return marks[foundIndex];
        }

        return null;
    }

    public void deleteMark(Mark mark) {
        Integer foundIndex = findMarkIndexByEntity(mark);

        if (foundIndex != null) {
            deleteMarkByIndex(foundIndex);
        }
    }

    public void deleteMark(Long id) {
        Integer foundIndex = findMarkIndexById(id);

        if (foundIndex != null) {
            deleteMarkByIndex (foundIndex);
        }
    }

    private void deleteMarkByIndex(int index) {
        ArrayUtils.removeElement(marks, index);
        markIndex--;
    }

    public void printMarks() {
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    private Integer findMarkIndexByEntity(Mark mark) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i].equals(mark)) {
                return i;
            }
        }

        return null;
    }

    private Integer findMarkIndexById(Long markId) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i].getId().equals(markId)) {
                return i;
            }
        }
        return null;
    }
}
