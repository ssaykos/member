<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 모듈화 되어있다.. 인클루드로 중복이 되지 않게 하기 위해서 이다. -->
    <style>
        @IMPORT url("<%= request.getContextPath() %>/css/kaup.css");
   </style>
 
    
    <form action="<%=request.getContextPath()%>/model2/join.do" method="post" name="frmJoin">
        <fieldset>
        <legend>회원 가입</legend>
        <table>
            <tr>
                <td>이름 </td>
                <td>
                    <input type="text" id="name" name="name" placeholder="이름을 입력하세요" />
                </td>
            </tr>
            <tr>
                <td>ID </td>
                <td>
                    <input type="text" id="id" name="id" placeholder="ID 값을 입력하세요" />
                </td>
            </tr>
            <tr>
                <td>Password </td>
                <td>
                    <input type="password" id="password" name="password"  />
                </td>
            </tr>
                <tr>
                <td>나이 </td>
                <td>
                    <input type="text" id="age" name="age" placeholder="나이를 입력하세요" />
                </td>
            </tr>
                <tr>
                <td>이메일 </td>
                <td>
                    <input type="text" id="email" name="email" placeholder="이메일을 입력하세요" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <!-- <input type="submit" value="전 송" /> -->
                    <img src="<%=request.getContextPath()%>/images/btnJoin.jpg" 
                            style="cursor: pointer;width: 150px;" 
                    alt="" onclick="return Member.join()"/>
                </td>
            </tr>
        </table>
        </fieldset>
    </form>
    
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/Member.js"></script>
 
