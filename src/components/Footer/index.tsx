import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import {BLOG_LINK} from "@/constants";
const Footer: React.FC = () => {
  const defaultMessage = '西风の轻语出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'codeNav',
          title: '博客园',
          href: BLOG_LINK,
          blankTarget: true,
        },
        {
          key: 'gitee',
          title: '啦啦啦 Gitee',
          href: 'https://gitee.com/dieshadow',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined /> 啦啦啦 Github</>,
          href: 'https://github.com/Zxy-dny',
          blankTarget: true,
        },

      ]}
    />
  );
};
export default Footer;
