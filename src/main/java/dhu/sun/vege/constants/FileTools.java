package dhu.sun.vege.constants;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传工具类
 *
 * @author Think
 * @date 2017/11/14
 */
public class FileTools {

    public Map<String, Object> save(MultipartFile newFile, String basePath) throws Exception {
        if (newFile == null)
            return null;

        Map<String, Object> map = new HashMap<>();
        String fileName;

        String originalFileName = newFile.getOriginalFilename();
        map.put("name", originalFileName);//name
        map.put("size", newFile.getSize());//size
        if (newFile != null && originalFileName != null && originalFileName.length() > 0) {
            //按照日期命名文件  如2017年11月,则文件名为   2017-11
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            String date = simpleDateFormat.format(new Date());

            //物理路径
            String path = basePath + date + "/";

            //新的文件名称
            String newFileName;
            //有后缀保存后缀,无后缀直接UUID
            if (originalFileName.contains(".")) {
                newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            } else {
                newFileName = UUID.randomUUID() + "";
            }

            //保存新图片
            File saveFile = new File(path + newFileName);
            // 获取父文件
            //如果父文件夹不存在,创建
            File parent = saveFile.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            //将内存中的数据写入磁盘
            newFile.transferTo(saveFile);

            fileName = date + "/" + newFileName;
            map.put("path", fileName);

            return map;
        }
        return null;
    }

    public boolean delete(String path) {
        File file = new File(path);
        //如果文件不存在 或者 文件是目录
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        return file.delete();
    }
}
