package in.techcamp.issueapp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IssueRepository {
    @Select("select * from issues")
    List<IssueEntity> findAll();
}
