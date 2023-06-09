USE [eduManagement_202108060520]
GO
/****** Object:  Table [dbo].[course]    Script Date: 2023/6/2 9:17:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[course](
	[no] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[address] [int] NOT NULL,
	[credit] [int] NOT NULL,
	[addressName] [nchar](10) NULL,
 CONSTRAINT [course_pk] PRIMARY KEY CLUSTERED 
(
	[no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[grade]    Script Date: 2023/6/2 9:17:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[grade](
	[Sno] [int] NOT NULL,
	[Cno] [int] NOT NULL,
	[grade] [int] NULL,
 CONSTRAINT [grade_pk] PRIMARY KEY CLUSTERED 
(
	[Sno] ASC,
	[Cno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 2023/6/2 9:17:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[no] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[sex] [int] NOT NULL,
	[age] [int] NOT NULL,
	[address] [nvarchar](50) NULL,
	[sexName] [nchar](10) NULL,
 CONSTRAINT [student_pk] PRIMARY KEY CLUSTERED 
(
	[no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[grade]  WITH CHECK ADD  CONSTRAINT [grade_Cno_fk] FOREIGN KEY([Cno])
REFERENCES [dbo].[course] ([no])
GO
ALTER TABLE [dbo].[grade] CHECK CONSTRAINT [grade_Cno_fk]
GO
ALTER TABLE [dbo].[grade]  WITH CHECK ADD  CONSTRAINT [grade_Sno_fk] FOREIGN KEY([Sno])
REFERENCES [dbo].[student] ([no])
GO
ALTER TABLE [dbo].[grade] CHECK CONSTRAINT [grade_Sno_fk]
GO
