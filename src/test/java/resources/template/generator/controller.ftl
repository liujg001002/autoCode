package ${basePackageController};

import ${basePackage}.common.restful.ResResult;
import ${basePackage}.common.restful.ResResponse;
import ${basePackage}.common.core.utils.ApplicationUtils;
import ${basePackageModel}.${modelNameUpperCamel};
import ${basePackageService}.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: ${modelNameUpperCamel}Controller类
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("/${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/insert")
    public ResResult<Integer> insert(${modelNameUpperCamel} ${modelNameLowerCamel}) throws Exception{
		${modelNameLowerCamel}.setId(ApplicationUtils.snowFlakeID());
    	Integer state = ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
        return ResResponse.ok(state);
    }

    @PostMapping("/deleteById")
    public ResResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = ${modelNameLowerCamel}Service.deleteById(id);
        return ResResponse.ok(state);
    }

    @PostMapping("/update")
    public ResResult<Integer> update(${modelNameUpperCamel} ${modelNameLowerCamel}) throws Exception {
        Integer state = ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResResponse.ok(state);
    }

    @PostMapping("/selectById")
    public ResResult<${modelNameUpperCamel}> selectById(@RequestParam String id) throws Exception {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectById(id);
        return ResResponse.ok(${modelNameLowerCamel});
    }

    /**
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn ResResult<PageInfo<${modelNameUpperCamel}>>
	*/
    @PostMapping("/list")
    public ResResult<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page,
					@RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        return ResResponse.ok(pageInfo);
    }
}