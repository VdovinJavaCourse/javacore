package autoservice.mark.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.mark.domain.Mark;
import autoservice.mark.repo.MarkRepo;
import autoservice.mark.search.MarkSearchCondition;

import static autoservice.storage.Storage.marks;

public class MarkMemoryArrayRepo implements MarkRepo {

    private static final Mark[] EMPTY_MARKS_ARR = new Mark[0];
    private int markIndex = -1;

    public void add(Mark mark) {
        if (markIndex == marks.length - 1) {
            Mark[] newArrMarks = new Mark[marks.length * 2];
            System.arraycopy(marks, 0, newArrMarks, 0, marks.length);
            marks = newArrMarks;
        }

        markIndex++;
        marks[markIndex] = mark;
    }

    @Override
    public Mark[] search(MarkSearchCondition searchCondition) {
        return EMPTY_MARKS_ARR;
    }

    public Mark findById(long id) {
        Integer foundIndex = findMarkIndexById(id);
        if (foundIndex != null) {
            return marks[foundIndex];
        }

        return null;
    }

   /* public void deleteMark(Mark mark) {
        Integer foundIndex = findMarkIndexByEntity(mark);

        if (foundIndex != null) {
            deleteMarkByIndex(foundIndex);
        }
    }*/

    public void deleteById(Long id) {
        Integer foundIndex = findMarkIndexById(id);

        if (foundIndex != null) {
            deleteMarkByIndex(foundIndex);
        }
    }

    private void deleteMarkByIndex(int index) {
        ArrayUtils.removeElement(marks, index);
        markIndex--;
    }

    public void printAll() {
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    /*private Integer findMarkIndexByEntity(Mark mark) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i].equals(mark)) {
                return i;
            }
        }

        return null;
    }*/

    private Integer findMarkIndexById(Long markId) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] != null && marks[i].getId().equals(markId)) {
                return i;
            }
        }
        return null;
    }
}
