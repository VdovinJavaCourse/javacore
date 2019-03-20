package autoservice.mark.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.mark.domain.Mark;
import autoservice.mark.repo.MarkRepo;
import autoservice.mark.search.MarkSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static autoservice.common.solutions.utils.StringUtils.isNotBlank;
import static autoservice.storage.Storage.marksArray;
import static autoservice.storage.Storage.marksList;

public class MarkMemoryArrayRepo implements MarkRepo {

    private static final Mark[] EMPTY_MARKS_ARR = new Mark[0];
    private int markIndex = -1;

    public void add(Mark mark) {
        if (markIndex == marksArray.length - 1) {
            Mark[] newArrMarks = new Mark[marksArray.length * 2];
            System.arraycopy(marksArray, 0, newArrMarks, 0, marksArray.length);
            marksArray = newArrMarks;
        }

        markIndex++;
        marksArray[markIndex] = mark;
    }

    @Override
    public List<Mark> search(MarkSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByCountry = isNotBlank(searchCondition.getCountry());

            boolean searchByName = isNotBlank(searchCondition.getName());

            List<Mark> result = new ArrayList<>();

            for (Mark mark : marksList) {
                if (mark != null) {
                    boolean found = false;

                    if (searchByCountry) {
                        found = searchCondition.getCountry().equals(mark.getCountry());
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(mark.getName());
                    }

                    if (found) {
                        result.add(mark);
                    }
                }
            }
            return result;
        }
    }

    public Mark findById(long id) {
        Integer foundIndex = findMarkIndexById(id);
        if (foundIndex != null) {
            return marksArray[foundIndex];
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
        ArrayUtils.removeElement(marksArray, index);
        markIndex--;
    }

    public void printAll() {
        for (Mark mark : marksArray) {
            System.out.println(mark);
        }
    }

    /*private Integer findMarkIndexByEntity(Mark mark) {
        for (int i = 0; i < marksArray.length; i++) {
            if (marksArray[i].equals(mark)) {
                return i;
            }
        }

        return null;
    }*/

    private Integer findMarkIndexById(Long markId) {
        for (int i = 0; i < marksArray.length; i++) {
            if (marksArray[i] != null && marksArray[i].getId().equals(markId)) {
                return i;
            }
        }
        return null;
    }
}
