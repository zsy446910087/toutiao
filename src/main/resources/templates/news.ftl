<html>
<body>
<pre>
Hello freemarker
    <!--这是一个注释-->
<#--着也是一个注释-->

${value1}
${value2!"无效变量"}
${value3!}
<#list colors as color>
    Color ${color_index+1}:<td>${color!}</td>
</#list>
<#list map?keys as key>
    key:${key}
    value=${map[key]}
</#list>
user:${user.name}
    <!--user=${user.getName()}-->
<#assign title="wo" />
<#include "header.ftl" /><br>
<#import "header.ftl" as title1 />
${title1.title}
${title}

<#macro render_color index color1>
    Color By Macro ${index},${color1}
</#macro>
<#list colors as color>
    <@render_color index=color_index color1=color></@render_color>
</#list>

</pre>
</body>
</html>