package volleyball.volleyballprogram.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import volleyball.volleyballprogram.entity.Team;
import volleyball.volleyballprogram.service.TeamService;

import java.util.Optional;


@RestController
@RequestMapping("/api/team")
public class TeamApi {
    @Autowired
    TeamService teamService;


    //添加队伍
    @PostMapping
    //输入地址：http://localhost:8080/ball/api/team Post
    // 输入数据   {
    //        "teamName":"信院男排1队",
    //            "teamInfo":"广财菜菜队",
    //            "teamCollege":"信院",
    //            "teamImg":"暂无"
    //    }
    //成功返回数据"ok"
    public String addTeam(@RequestBody Team team){
        teamService.addTeam(team);
        return "ok";
    }


    //根据teamCollege获取该学院所有队伍列表
    @GetMapping("search")
    //输入地址 http://localhost:8080/ball/api/team/search?name=信院&page=0&size=5 get
    //输入数据name，page,size
    //成功返回数据      "content": [
    //        {
    //            "id": 4,
    //            "teamName": "信院女排1队",
    //            "teamInfo": "广财最美最强队",
    //            "teamCollege": "信院",
    //            "teamImg": "暂无"
    //        },
    //        {
    //            "id": 5,
    //            "teamName": "信院女排2队",
    //            "teamInfo": "广财最美最强队",
    //            "teamCollege": "信院",
    //            "teamImg": "暂无"
    //        },
    //        {
    //            "id": 6,
    //            "teamName": "信院女排3队",
    //            "teamInfo": "广财最美最强队",
    //            "teamCollege": "信院",
    //            "teamImg": "暂无"
    //        }
    //    ],
    public Page<Team> getTeamByCollegeName(String name, int page, int size){
        return teamService.getTeamByColllegeName(name, PageRequest.of(page,size));
    }



    //根据teamName来获取相关信息
    @GetMapping("find")
    //输入地址：http://localhost:8080/ball/api/team/find?name=信院女排1队  get
    //输入数据 name=信院女排1队
    //成功返回数据 {
    //    "id": 4,
    //    "teamName": "信院女排1队",
    //    "teamInfo": "广财最美最强队",
    //    "teamCollege": "信院",
    //    "teamImg": "暂无"
    //}
    public Optional<Team> getTeamByTeamName(String name){
        return teamService.getTeamByTeamName(name);
    }









}
