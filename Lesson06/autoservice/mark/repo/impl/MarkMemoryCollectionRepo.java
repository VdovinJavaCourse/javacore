package autoservice.mark.repo.impl;

import autoservice.mark.domain.Mark;
import autoservice.mark.repo.MarkRepo;
import autoservice.mark.search.MarkSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static autoservice.common.solutions.utils.StringUtils.isNotBlank;
import static autoservice.storage.Storage.marksList;

public class MarkMemoryCollectionRepo implements MarkRepo {
    @Override
    public Mark findById(long id) {
        return findMarkById(id);
    }

    @Override
    public void add(Mark mark) {
        marksList.add(mark);
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

    @Override
    public void deleteById(Long id) {
        Mark found = findMarkById(id);

        if (found != null) {
            marksList.remove(findById(id));
        }
    }

    @Override
    public void printAll() {
        for (Mark mark : marksList) {
            System.out.println(mark);
        }
    }

    private Mark findMarkById(Long markId) {
        for (Mark mark : marksList) {
            if (Long.valueOf(markId).equals(mark.getId())) {
                return mark;
            }
        }
        return null;
    }
}
