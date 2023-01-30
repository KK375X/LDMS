<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            margin: 50px 0 0 0;
        }

        td {
            width: 100px;
            height: 50px;
            text-align: center;
            border: 2px solid #000;
        }

        .change {
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, .5);
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            display: none;
        }

        .change>div {
            padding: 30px 20px;
            height: 200px;
            background: #fff;
        }
    </style>
</head>

<body>
<div name="add">
    姓名: <input type="text" name="name"><br>
    年龄: <input type="text" name="age"><br>
    城市: <select>
    <option value="0">北京</option>
    <option value="1">上海</option>
    <option value="2">广州</option>
    <option value="3">重庆</option>
    <option value="4">天津</option>
</select><br>
    性别: <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女
    <input type="radio" name="sex" value="保密">保密
    <br>
    <button>新增</button>
</div>


<div class="change" name="change">
    <div>
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        城市: <select>
        <option value="0">北京</option>
        <option value="1">上海</option>
        <option value="2">广州</option>
        <option value="3">重庆</option>
        <option value="4">天津</option>
    </select><br>
        性别: <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
        <input type="radio" name="sex" value="保密">保密
        <br>
        <button name="c">修改</button>
        <button name="q">取消</button>
    </div>
</div>



<table>
    <thead>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>城市</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    </thead>
    <tbody></tbody>
</table>



<script>
    const arr = [{
        id: 1,
        name: '张三',
        age: 18,
        sex: '男',
        addr: '北京'
    },
        {
            id: 2,
            name: '李四',
            age: 19,
            sex: '女',
            addr: '上海'
        },
        {
            id: 3,
            name: '王五',
            age: 20,
            sex: '男',
            addr: '广州'
        },
        {
            id: 4,
            name: '赵六',
            age: 21,
            sex: '女',
            addr: '重庆'
        },
        {
            id: 5,
            name: '刘七',
            age: 22,
            sex: '男',
            addr: '天津'
        },
    ];

    // 定义数组 存储城市名称信息
    const cityArr = ['北京', '上海', '广州', '重庆', '天津'];

    // 调用函数 生成 动态渲染 生成标签对象
    setPage();

    // 新增操作:
    // 获取标签对象 新增标签对象
    const oAddDiv = document.querySelector('[name="add"]');
    const oBtnAdd = oAddDiv.querySelector('button');
    const oAddName = oAddDiv.querySelector('[name="name"]');
    const oAddAge = oAddDiv.querySelector('[name="age"]');
    const oAddCity = oAddDiv.querySelector('select');
    const oAddSex = oAddDiv.querySelectorAll('[type="radio"]');

    // 修改操作
    // 获取标签对象 修改标签对象
    const oChangeDiv = document.querySelector('[name="change"]');
    const oBtnChange = document.querySelector('[name="c"]');
    const oBtnCancel = document.querySelector('[name="q"]');

    const oChangeName = oChangeDiv.querySelector('[name="name"]');
    const oChangeAge = oChangeDiv.querySelector('[name="age"]');
    const oChangeCity = oChangeDiv.querySelector('select');
    const oChangeSex = oChangeDiv.querySelectorAll('[type="radio"]');


    // 定义变量 存储 索引下标
    let index = 0;

    // 添加点击事件
    oBtnAdd.addEventListener('click', function () {
        // 获取数据
        var name = oAddName.value;
        var age = oAddAge.value;
        var city = oAddCity.value;
        // 定义变量准备存储 性别数据
        var sex = '';
        console.log(name, age, city);

        // 循环遍历 单选框伪数组
        oAddSex.forEach(function (item) {
            // item 就是 单选框标签
            // 如果 item.checked 是 true
            // 也就是这个标签被选中
            // 获取这个标签的value数值
            if (item.checked) {
                // 获取 这个标签的value数据
                sex = item.value;
            }
        })

        // 向 数组 新增 对象单元
        // id 是最后有一个单元的 id值 +1
        // select的数据 是 数组通过索引下标获取的对应的数值
        arr.push({
            id: arr[arr.length - 1].id + 1,
            name: name,
            age: age,
            sex: sex,
            addr: cityArr[city]
        });
        console.log(arr);

        // 再次调用函数 动态渲染生成页面
        setPage();
    })



    // 删除操作 事件委托
    // 修改操作 事件委托
    var oTbody = document.querySelector('tbody');
    oTbody.addEventListener('click', function (e) {
        // 通过 e.target 的 name属性 判断 如果是del是删除按钮
        if (e.target.getAttribute('name') === 'del') {
            // 执行删除程序
            // 删除数组中 和 对应的删除按钮 匹配的数组中的数据
            // 获取 删除对象单元的索引下标 也就是 标签中 index属性的属性值
            // 获取的属性值 都是字符串类型 需要转化为数值类型
            var num = e.target.getAttribute('index') - 0;
            console.log(num);

            // 用 index的属性值 作为 索引下标 从数组中删除一个对象
            arr.splice(num, 1);
            console.log(arr);

            // 再次调用函数 动态渲染生成页面
            // 再次动态渲染生成的页面 内容是全新的页面内容
            setPage();

            // 通过 e.target 的 name属性 判断 如果是change是修改按钮
        } else if (e.target.getAttribute('name') === 'change') {
            // 让 修改div显示
            // 变量储存点击标签对应的数组的索引下标
            oChangeDiv.style.display = 'flex';
            // 变量 存储 点击标签index属性属性值
            index = e.target.getAttribute('index') - 0;
        }
    })


    // 修改div中的取消按钮
    // 点击时 让 修改div隐藏
    oBtnCancel.addEventListener('click', function () {
        oChangeDiv.style.display = 'none';
    })

    // 修改div中的修改按钮
    // 获取数据
    // 修改 索引下标对应的数组单元中,存储对象的数据
    // 根据新的数组动态渲染生成页面
    // 让修改div隐藏
    oBtnChange.addEventListener('click', function () {
        // 获取数据
        // input 直接获取数据
        // select 获取索引下标 从数组中获取对应的数据
        // input>radio  input>checkbox 判断 checked为true 再获取数据
        let name = oChangeName.value;
        let age = oChangeAge.value;
        let city = cityArr[oChangeCity.value];
        let sex = '';
        oChangeSex.forEach(function (item) {
            if (item.checked) {
                sex = item.value;
            }
        })

        // 修改数组中对应索引下标的标签对象
        // 也就是 给 索引下标对应的单元 重新存储一个对象
        // arr[index] = {id:arr[index].id,name:name,age:age,sex:sex,addr:city};

        // 一个一个属性的修改数据
        arr[index].name = name;
        arr[index].age = age;
        arr[index].sex = sex;
        arr[index].addr = city;

        // 根据新的数组动态渲染生成新的页面内容
        setPage();

        // 让修改div隐藏
        oChangeDiv.style.display = 'none';
    })


    // 动态渲染生成页面的函数
    function setPage() {
        // 定义字符串 存储 生成的标签内容
        var str = '';

        // 循环遍历 数组 每一个数组单元存储数据 生成一个对应的 tr>td
        // item 就是 存储数据的对象
        // key 存储 对象的索引下标
        arr.forEach(function (item, key) {
            str += `
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.age}</td>
                        <td>${item.sex}</td>
                        <td>${item.addr}</td>
                        <td><button name="del" index="${key}">删除</button></td>
                        <td><button name="change" index="${key}">修改</button></td>
                    </tr>
                `;
        })

        // 将字符串写入到标签对象中
        var oTbody = document.querySelector('tbody');
        oTbody.innerHTML = str;
    }
</script>
</body>

</html>
