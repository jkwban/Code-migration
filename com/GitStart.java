import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GitStart {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String url="D:\\aa\\ppp";

        while (true){
            System.out.println("输入来源url");
            String origin=scanner.nextLine();
            System.out.println("输入去向url");
            String update=scanner.nextLine();
            String[] split = origin.split("/");
            String originName = split[split.length - 1].split("\\.")[0];
            String command99="cmd /c cd \""+url+"\"";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(command99).append(" && ");
//            extracted(command99);
            String command = "git clone"+" "+origin;
            stringBuilder2.append(command);
            extracted(stringBuilder2.toString());
            StringBuilder stringBuilder = new StringBuilder();
            String command1 = "cmd /c cd \""+url+"\\"+originName+"\"";
            stringBuilder.append(command1).append(" && ");
//            extracted(command1);
            String command2 = "git remote add n1 "+update;
            stringBuilder.append(command2).append(" && ");
//            extracted(command2);
//            String command5 = "git fetch n1";
//            stringBuilder.append(command5).append(" && ");
//            extracted(command5);
//            String command6 = "git fetch origin";
//            stringBuilder.append(command6).append(" && ");
//            extracted(command6);
            String command8 = "git pull n1 main";
            stringBuilder.append(command8);
            extracted(stringBuilder.toString());

            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(command1).append(" && ");
            String command9 = "git checkout main";
            stringBuilder3.append(command9).append(" && ");
//            extracted(command9);
            String command10 = "git merge origin/master --strategy=recursive --strategy-option=theirs --allow-unrelated-histories --no-edit";
            stringBuilder3.append(command10).append(" && ");
//            extracted(command10);
            String command11 = "git push n1 main";
            stringBuilder3.append(command11);
//            extracted(command11);
            extracted(stringBuilder3.toString());
            extracted(command1+" && "+"git branch -a");
//           extracted(command3);
            while (true){
                System.out.println("输入你要选择的操作0 跳过重新输入 1 进行下一步 2准备下一个工程");
                int i = scanner.nextInt();
                System.out.println("记得情况nextInt空格");
                scanner.nextLine();
                if (i==0){
                    continue;
                }else if (i==2){
                    String command14 = "cmd /c  cd \""+url+"\"";
                    extracted(command14);
                    break;
                }
                System.out.println("输入你要push的分支");
                String branch = scanner.nextLine();
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(command1).append(" && ");
                String command12 = "git checkout "+branch;
                stringBuilder1.append(command12).append(" && ");
//                extracted(command12);
                String command13 = "git push n1 "+branch;
//                extracted(command13);
                stringBuilder1.append(command13).append(" && ");
                String command15 = "git branch -a";
                stringBuilder1.append(command15);
                extracted(stringBuilder1.toString());
            }
        }
    }

    private static void extracted(String command) {
        try {
            System.out.println(command);

            Process process = Runtime.getRuntime().exec(command);
            // 获取命令输出
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // 打印命令的输出
            }
            // 等待命令执行完毕
            int exitCode = process.waitFor();
            System.out.println("Git command executed with exit code: " + exitCode+"\n");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
